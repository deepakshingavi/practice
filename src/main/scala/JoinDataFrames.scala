import org.apache.spark.sql.DataFrame

object JoinDataFrames {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val df = List(("toto","tata","titi")).toDF("A","B","C")

    val N = 3;

    val resultDf = (1 until N).foldLeft( df)((dfInner : DataFrame, count : Int) => {
      df.union(dfInner)
    })

    resultDf.show()

  }

}
