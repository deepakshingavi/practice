import java.util.Calendar

import org.apache.spark.rdd
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{DataType, StructField, StructType}

/*class CallByName {
  var x : Int
}*/
object CallByName {



  private def inc(x: => Int): Unit = {
//    x += 1
  }

  /*private def inc1(obj: => CallByName): Unit = {
    obj.x += 1
  }*/

  def main(args: Array[String]): Unit = {
    /*var x = 0
    inc(x)
    println(x)*/
    val newSchema : StructType = DataType.fromJson("""{
                                        |  "type": "struct",
                                        |  "fields": [
                                        |    {
                                        |      "name": "id",
                                        |      "type": "string",
                                        |      "nullable": true,
                                        |      "metadata": {}
                                        |    },
                                        |    {
                                        |      "name": "migration",
                                        |      "type": "string",
                                        |      "nullable": true,
                                        |      "metadata": {}
                                        |    },
                                        |    {
                                        |      "name": "number",
                                        |      "type": "integer",
                                        |      "nullable": false,
                                        |      "metadata": {}
                                        |    },
                                        |    {
                                        |      "name": "string",
                                        |      "type": "string",
                                        |      "nullable": true,
                                        |      "metadata": {}
                                        |    }
                                        |  ]
                                        |}""".stripMargin).asInstanceOf[StructType] // Load you schema from JSON string


//    println(newSchema)
    val spark = Constant.getSparkSess // Create SparkSession object
    import org.apache.spark.sql.types.StructType
    val schema = new StructType

    //Correct data
    val correctData: rdd.RDD[Row]  = spark.sparkContext.parallelize(Seq(Row("5e5db036e0403b1a.","mig",1,"str")))
    val dfNew = spark.createDataFrame(correctData, newSchema) // validating the data

    dfNew.show()

    spark.read.format("avro").load

    //InCorrect data
    val inCorrectData: rdd.RDD[Row]  = spark.sparkContext.parallelize(Seq(Row("5e5db036e0403b1a.",1,1,"str")))

    val dfInvalid = spark.createDataFrame(inCorrectData, newSchema) // validating the data which will throw RuntimeException: java.lang.Integer is not a valid external type for schema of string
    dfInvalid.show()
    Calendar.getInstance()

    val res = spark.sql("")
    val diffColumn : Seq[StructField] = res.schema.diff(newSchema)
    diffColumn.foreach(_.name)

  }
}


