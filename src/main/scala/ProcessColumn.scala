import org.apache.spark.sql.functions._

object ProcessColumn {

  def main(args: Array[String]): Unit = {


    val spark = Constant.getSparkSess
    import spark.implicits._

    val df = Seq((1, "051", 0, 0, 10, 0), (1, "052", 0, 0, 0, 0), (2, "053", 10, 0, 10, 0), (2, "054", 0, 0, 10, 0))
      .toDF("id", "code", "value_1", "value_2", "value_3", "Value_4")

    df.persist()

    df.repartition(6)

    df.withColumn("collectCols",array("value_1", "value_2", "value_3", "Value_4"))
      .withColumn("maxValue",array_max(col("collectCols") ))
      .withColumn("flag",
        when( size(array_remove(col("collectCols"),col("maxValue"))) ===
          (size(array("value_1", "value_2", "value_3", "Value_4"))-1)
          ,lit(true)  )
        .otherwise(lit(false)))
      .filter(col("flag"))
      .show()


  }

}
