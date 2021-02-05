import java.nio.file.Paths

import org.apache.spark.sql.{Encoders, SaveMode, SparkSession}
import org.apache.spark.sql.functions._

object ReadWriteToRespCsv {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder.master("local[*]").getOrCreate;

    val baseDf = spark.read.csv("src/main/resources/same_folder/*.csv")
      //Add a column `input_file_name` which records source file name
      .withColumn("input_file_name",input_file_name())

    //Collect the file names into a List
    val filePathInfo = baseDf.select("input_file_name").distinct()
      .map(row=>Paths.get(row.getString(0)).getFileName.toString)(Encoders.STRING).collect()

    //Iterate for file name list
    filePathInfo.foreach(csvFileName => {
      baseDf
        //Filter dataframe by file name
        .filter(col("input_file_name").endsWith(csvFileName) )
        .write
        .mode(SaveMode.Overwrite)
        //Write to respective file
        .parquet(s"src/main/resources/output_folder/${csvFileName}")
    })
  }

}
