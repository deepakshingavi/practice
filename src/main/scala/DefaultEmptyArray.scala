import org.apache.spark.sql.functions._

object DefaultEmptyArray {

  def main(args: Array[String]): Unit = {
    val input = List(Bean(List("A","B")),Bean(null),Bean(List("C","D")))
    val spark = Constant.getSparkSess
    val df  = spark.createDataFrame(input)

    df.select("inputList")
      .withColumn("outputList",when (col("inputList").isNull,Array[String]()).otherwise(col("inputList")))
      .show()
  }
}

case class Bean( inputList : List[String])
