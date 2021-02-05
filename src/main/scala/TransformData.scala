import org.apache.spark.sql.functions._

object TransformData {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List("Alice;Bob;Carol",
    "12;13;14",
    "5;;7",
    "1;;3",
    ";;3").toDF("data")


    val transpose = (1 to 3).zipWithIndex.map {
      case (_, index) => {
        col("data").getItem(index).as(s"col_${index}")
      }
    }

    df.select(split(col("data"),";").as("data"))
      .select(transpose: _*)
      .withColumn("tempCol",lit(1))
      .groupBy("tempCol")
      .agg(collect_list("col_0"),
        collect_list("col_1"),
        collect_list("col_2"))
      .show()


  }

}
