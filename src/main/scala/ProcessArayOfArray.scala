import org.apache.spark.sql.functions.monotonically_increasing_id

object ProcessArayOfArray {

  def main(args: Array[String]): Unit = {
    val arrarr = Array(Array(0.37,1),Array(145.38,100),Array(149.37,100),Array(149.37,300),Array(119.37,5),Array(144.37,100))

    val spark = Constant.getSparkSess
    import spark.implicits._
    arrarr.toSeq.toDF.withColumn("id",monotonically_increasing_id()).map(row => {
      row.getDouble(0) -> (row.getDouble(1),row.getDouble(2))
    })


    val tempDf = List("a","b","c",null).toDF()
    tempDf.show()

    tempDf.na.fill("").show()


  }

}
