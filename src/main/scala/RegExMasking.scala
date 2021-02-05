import org.apache.spark.sql.functions._

object RegExMasking {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    //Regex to fetch the word
    val regEx : String = """(\s+[A-Z|a-z]+\s)""".stripMargin

    //load your Dataframe
    val df = List("Narendra Modi pm of india 2020-JUN-03",
      "Donald Trump president of USA ").toDF("sentence")

    df.withColumn("valueToReplace",
      //Fetch the 1st word from the regex parse expression
          regexp_extract(col("sentence"),regEx,0)
        )
        .map(row => {
          val sentence = row.getString(0)

          //Trim for extra spaces
          val valueToReplace : String = row.getString(1).trim

          //Create masked string of equal length
          val replaceWith  = List.fill(valueToReplace.length)("X").mkString

          // Return sentence , masked sentence
          (sentence,sentence.replace(valueToReplace,replaceWith))
        }).toDF("sentence","maskedSentence")
      .show()
  }

}
