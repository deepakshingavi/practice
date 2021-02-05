import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DataTypes._

object AddTimeStampColumn {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(1,2,3).toDF

    df.withColumn("epocInMillis", (unix_timestamp() * lit(1000)) +
      (lit(85) * monotonically_increasing_id()).cast(LongType))
      .withColumn("timeStamp",
      from_unixtime( (unix_timestamp() * lit(1000)) +
        (lit(85) * monotonically_increasing_id()).cast(LongType) , "MM-dd-yyyy HH:mm:ss.SSSSSS" ) )
      .show(false)
  }

}
