import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{ArrayType, FloatType, StringType, StructField, StructType}

object ApplySchema {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    //Create Dataframe from the List
    val sampleDf = List((5203754,15.0,1.0,5.0,"""[{"packQty":120.0,"gtin":"00052000042276"}]"""),
      (5203754,15.0,1.0,2.0,"""[{"packQty":120.0,"gtin":"00052000042276"}]""")
      ,(5203754,25.0,1.0,2.0,"na")
    ).toDF("orderupcnumber","enrichqty","allocoutqty","allocatedqty","gtins") // Map the column to data

    //JSON schema
    val schema = ArrayType(StructType(StructField("packQty",FloatType,true)::
      StructField("gtin",StringType,true) :: Nil))



    //Add column JSON parsed column "jsonData"
    sampleDf.withColumn("jsonData",
      when($"gtins"=!="na",from_json($"gtins",schema)) // Check if the value is NA then parse the JSON
      .otherwise(from_json(lit("[]"),schema))) // Else parse an empty JSON array
      .show()

  }

}
