object LoadJoinDataframe {

  def main(args: Array[String]): Unit = {
    val cols = List("ID", "Subject")

    val file_path = List("path to a.csv", "path to b.csv")


    val spark = Constant.getSparkSess
    val df = spark
      .read
      .option( "header", "true" )
      .option( "delimiter", "," )
      .csv(file_path: _* )
      .select(cols.head, cols.tail: _*)
    df.show()
    df.count()

  }

}
