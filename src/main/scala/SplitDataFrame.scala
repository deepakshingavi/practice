object SplitDataFrame {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val epochs = List(1539754800,
      1539754800,
      1539931200,
      1539927600,
      1539927600,
      1539931200,
      1539931200,
      1539931200,
      1539927600,
      1540014000,
      1540014000,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400,
      1540190400).toDF  // Define your base Dataframe

    val splittingRatio = 0.6 // define your sploit ratio
    val dfCount = epochs.count() // get df total count
    val df1Count: Int = (dfCount * splittingRatio).toInt  // get total count for first dataFrame
    val df2Count: Int = (dfCount - df1Count).toInt        // get total count for Second dataFrame

    val df1 = epochs.limit(df1Count) // First dataframe 30 * 0.6 = 18
    val df2 = epochs.limit(df2Count) // First dataframe 30 * 0.4 = 12
  }

}
