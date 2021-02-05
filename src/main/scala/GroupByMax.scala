import org.apache.spark.sql.functions._

object GroupByMax {
  def main(args: Array[String]): Unit = {


    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(("2010-01-01",     "23",     "28"),
      ("2010-01-01",     "23",     "28"),
      ("2010-01-01",     "23",     "28"),
      ("2010-01-01",     "23",     "28")
    ).toDF("Date","Col1","Col2")
    df.groupBy("Date").agg(max("Col1"),max("Col2"))
      .show()
  }
}
