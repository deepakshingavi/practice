import org.apache.spark.sql.functions._

object CheckDigitInString {

  def main(args: Array[String]): Unit = {
    val input = "abc def ghi2 xyz4"
    val spark = Constant.getSparkSess
    import spark.implicits._
    val inputDf = input.split(" ").toSeq.toDF

    val output = inputDf.where(col("value").rlike(".*[0-9]+.*"))
      .map(row => row.getString(0))
      .collect().mkString(" ")
    println(output)
  }

}
