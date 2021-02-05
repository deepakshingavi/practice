import org.apache.spark.sql.functions

object TableNameRegexParser {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._

    val df = List((1, "select * from table_a, table_b"),
      (2, "select * from table_c join table_d..."))
      .toDF("id", "query")

  }

}
