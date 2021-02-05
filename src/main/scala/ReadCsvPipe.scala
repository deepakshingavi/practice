import org.apache.spark.sql.SaveMode

object ReadCsvPipe {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    spark.read
      .option("delimiter", "|")
      .csv("src/main/resources/sampleCsv1.csv")
      .toDF("column1","column2","column3")
      .coalesce(1).write.mode(SaveMode.Overwrite)
      .option("delimiter","\t")
      .option("header","true")
      .csv("src/main/resources/sampleCsv1Output")
  }

}
