import org.apache.spark.sql.functions._

object DerivedColum {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    import spark.implicits._
    val df = List(("John", "2020-01-01"),
      ("John", "2020-01-05"),
      ("John", "2020-01-09"),
      ("John", "2020-01-10"),
      ("John", "2020-01-17")).toDF("Customar", "visited_date")

    df.withColumn("allowed",
      when(to_date($"visited_date").gt(lit("2015-03-14")), "no").otherwise("yes")).show()
  }

}
