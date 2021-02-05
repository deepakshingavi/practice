object EscapeChar {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val df = List("_A_","A").toDF()
    df.printSchema()
    df.filter($"value".contains("_A_")).show()
  }

}
