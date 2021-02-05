import org.apache.spark.sql.functions._

object CompareCol {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._
    val df = List(("B", "c"), ("K", "G"), ("g", "A"), (null, null)).toDF("A", "B")


    df
      .withColumn("arrayCol", array_min(array(col("A"), col("B"))))
      .show()
  }

}
