object LoadTempParquet {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    spark
      .read
      .parquet("/Users/dshingav/tmp/temp.snappy.parquet")
      .show()
  }

}
