import org.apache.spark.sql.functions._

object GroupByAgg {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(("A", true,"Apple"), ("A", false,""),
      ("B", false,""),
      ("B", false,""),
      ("C", true,"Cat"),
      ("C", true,"Cotton"),
      ("C", true,"")).toDF("Col1", "Col2","Col3")

    //Group by 1st column
    df.groupBy("Col1")
      // Collect unique values
      .agg(collect_set("Col2").as("Col2_set"),collect_set("Col3").as("Col3_set"))
      //check if the array contains single true
      .withColumn("OutputCol2", when(array_contains(col("Col2_set"), true), true)
        .otherwise(false))
    .withColumn("OutputCol3",expr("filter(Col3_set, x -> x != '')"))
      .drop("Col2_set")
      .drop("Col3_set")
      .show()
  }

}
