import org.apache.spark.sql.functions._

object ConverToJson {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List((132, "rent count", 6),
      (132, "rent booked", 24),
      (132, "rent delayed", 6),
      (134, "rent booked", 34),
      (134, "rent delayed", 21)).toDF("booking_id", "status", "count(status)")

    df.groupBy("booking_id")
      .agg(to_json(map_from_arrays(collect_list("status"), collect_list("count(status)"))).as("status_json"))
      .show(false)

  }

}
