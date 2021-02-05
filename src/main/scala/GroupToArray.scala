import org.apache.spark.sql.functions

object GroupToArray {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    //Load your dataframe
    val df = List(("AA", "11"),
      ("BB", "21"),
      ("AA", "12"),
      ("AA", "13"),
      ("BB", "22"),
      ("CC", "33")).toDF("col1","col2")

    //Group by 'col1'
    df.groupBy("col1")
      //agregate on col2 and combine it to a list
    .agg(functions.collect_list("col2").as("newColumn"))
      .show()
  }

}
