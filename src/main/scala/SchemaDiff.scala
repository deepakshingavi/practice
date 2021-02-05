
object SchemaDiff {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    // Just because its a simple CSV not considering column data type changes
    /*val df1 : DataFrame = null // Dataframe for yesterday's data
    val df2 : DataFrame = null // Dataframe for today's data
    val deltaColumnNames = df2.columns.diff(df1.columns)
    val ignoreSchemaChange = true
    if(!deltaColumnNames.isEmpty) {
      println("Schema change")
    }
    val resultDf = if(ignoreSchemaChange) {
      df2.toDF(df1.columns: _*) // Maintain yesterday's schema
    } else {
      df2  // Use updated schema
    }

    val dfTsv1 = spark.read.format("com.databricks.spark.csv")
      .option("delimiter", "\t")
      .load("filepath1")
    val dfTsv2 = spark.read.format("com.databricks.spark.csv")
      .option("delimiter", "\t").load("filepath2")


    val duplicateColumns = List("") // put your duplicate column names here
    val outputDf = dfTsv1.alias("tcv1").join(dfTsv2.alias("tcv2"),dfTsv1("ACCESSED_MONTH") === dfTsv1("ACCESSED_MONTH"))
      .drop(duplicateColumns: _*)

    outputDf.show()*/
    import spark.implicits._
    val df1 = List("A").toDF()
    val df2 = List("B").toDF()

//    df1.join(df2).



  }
}
