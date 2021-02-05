import org.apache.spark.sql.functions._

object GroupColumns {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List( (0,"Key1",100),(1,"Key1",101),(2,"Key1",102),(3,"Key1",103),
      (0,"Key2",100),(1,"Key2",101),(2,"Key2",102),(3,"Key2",103)).toDF("id","Key","Values")

//    df.show()

    df.groupBy("Key")
      .agg(
        map(col("Key"),collect_list( struct(col("id"),col("Key"),col("Values")) ))
      .as("outputMap"))
      .drop("Key")
      .show(false)
  }

}
