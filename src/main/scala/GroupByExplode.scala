import org.apache.spark.sql.functions._

object GroupByExplode {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(("ACCARDI","EL83935"),("ACCARDI","AF35269")).toDF("last_name","ncid")

    df.groupBy(col("last_name")).agg(collect_list("ncid").as("ncid_agg"))
    .withColumn("ncid_exp",explode(col("ncid_agg")))
      .show()
  }

}
