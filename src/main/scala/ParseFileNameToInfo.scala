import org.apache.spark.sql.DataFrame

object ParseFileNameToInfo {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    val df : DataFrame = spark.read
      .format("csv")
      .option("delimiter", "_")
      .load("src/main/resources/sampleFileNames.txt")
      //You dont need schema definition as it alwyas simple and all columns are string
        .toDF("catg","sub_catg","doc_name","extraColumn")


    import spark.implicits._

    val output : DataFrame = df.rdd
      //Map the 4 columns to our output columns
      .map( row => {
      val extraColumn = row.getString(3)
      val fileInfo = extraColumn.substring(extraColumn.indexOf("-")+1).split("\\.")
      (row.getString(0),row.getString(1),row.getString(2).concat(row.getString(3)),fileInfo(0),fileInfo(1))
    })
      //Convert them to required output Dataframe
      .toDF("catg","sub_catg","doc_name","revision_label","extension")

    output.show()

  }

}
