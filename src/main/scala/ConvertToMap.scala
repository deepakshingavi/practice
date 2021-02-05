object ConvertToMap {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._
    val data =
      """
        |cod_cli|article_name|rank
        |123    |art_1       |1
        |123    |art_2       |2
        |123    |art_3       |3
        |456    |art_4       |1
        |456    |art_5       |2
        |456    |art_6       |3
      """.stripMargin
    val stringDS = data.split(System.lineSeparator())
      .map(_.split("\\|").map(_.replaceAll("""^[ \t]+|[ \t]+$""", "")).mkString(","))
      .toSeq.toDS()
    val df = spark.read
      .option("sep", ",")
      .option("inferSchema", "true")
      .option("header", "true")
      .option("nullValue", "null")
      .csv(stringDS)

    df.show(false)
    df.printSchema()

    df.groupBy("cod_cli")
  }

}
