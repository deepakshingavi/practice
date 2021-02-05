import org.apache.spark.sql.functions._

object JoinWhereList {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._
    val mainDf = List(Array("text1", "text"), Array("text4", "text")).toDF()
    val texts = Seq("text1", "text2", "text3")
    val whereExp = texts.map(text => s"array_contains(value, '$text')").toList.mkString(" OR ")

    val df = mainDf.select(col("*")).withColumnRenamed("value", "col1")
      .where(whereExp)
    df.show()

  }

}
