
object ReplaceQuotes {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess



    spark.read.text("src/main/resources/doubleQuoteFile.txt").map(row => {
      row.getString(0).replace("\"","\n") // looking to replace " " with next line
      row.getString(0).replace("\" \"","\n") // looking to replace " " with next line
    })(org.apache.spark.sql.Encoders.STRING)
  }

}

