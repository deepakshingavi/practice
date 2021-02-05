import org.apache.spark.sql.functions._

object TimeStampCol {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    var df = Seq(
      ("1300-01-03")
    ).toDF("date_val")
      .withColumn("date_val_ts", to_date(col("date_val")))
      .withColumn("year_val", year(to_date(col("date_val"))))
    df
      .show()

    Seq(("1300-01-03 00:00:00")).toDF("date_val")
      .withColumn("date_val_ts", to_timestamp(col("date_val")))
      .withColumn("year_val", year(to_timestamp(col("date_val")))).show()
  }

}
