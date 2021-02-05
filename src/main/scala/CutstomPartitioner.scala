import org.apache.spark.HashPartitioner

object CutstomPartitioner {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    val rdd = spark.sparkContext
      .objectFile[(Int, Int)]("path")
      .partitionBy(new HashPartitioner(spark.sparkContext.defaultParallelism))
      .persist()
  }

}
