import org.apache.spark.sql.functions._


object DFByFileName {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    //Load your JSON data
    var df = spark.read.format("json").load("s3://data/*.json")

    //Add a column with file name
    df = df.withColumn(
      "input_file", (input_file_name())
    )

    //Extract unique file postfix from the file names in a List
    val fileGroupList = df.select("input_file").map(row => {
      val fileName = row.getString(0)
      val index1 = fileName.lastIndexOf("_")
      val index2 = fileName.lastIndexOf(".")
      fileName.substring(index1 + 1, index2)
    }).collect()

    //Iterate file group name to map of (fileGroup -> Dataframe of file group)
    fileGroupList.map(fileGroupName => {
      df.filter($"input_file".endsWith(s"${fileGroupName}.json"))
      //perform dataframe operations
    })
  }

}
