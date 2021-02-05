import org.apache.spark.sql.functions._

object ParseAString {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val inputStr = "a1|a2|a3 b1|b2|b3".split(" ").toSeq.toDF

    inputStr.na.fill("")

    val result = inputStr
      .select( concat(lit("("),regexp_replace($"value","\\|",","),lit(")") ) )
      .map(row => {
        row.getString(0)
      })
      .collect().mkString(",")
    println(s"(${result})")

  }

}
