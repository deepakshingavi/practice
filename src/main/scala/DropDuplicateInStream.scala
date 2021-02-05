import org.apache.spark.sql.{DataFrame, Encoder, Encoders, SparkSession}

object DropDuplicateInStream {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").getOrCreate()
    val df : DataFrame = spark.readStream
      .format("socket")
      .option("host","localhost")
      .option("port","9090")
      .load()

    val stringEncoder: Encoder[String] = Encoders.STRING
    df.map( r => r.mkString)(stringEncoder)
      .groupByKey( s => "")(stringEncoder)
      .mapGroups((k,v) => {
        v.mkString("|")
      })(stringEncoder)
      .foreach(println(_))
  }

}
