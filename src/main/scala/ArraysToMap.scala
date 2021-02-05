import org.apache.spark.sql.functions._

object ArraysToMap {
  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    var df = List(
      Seq(("Alex", 1), ("is", 1), ("a", 1), ("good", 1), ("boy", 1)),
      Seq(("Bob", 1), ("Bob", 1), ("bad", 1), ("Bob", 1))).toDF()

    df= df.withColumn("mapps",explode(col("value")))

    df.show(false)
  }




}
