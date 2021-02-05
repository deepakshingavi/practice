import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{MapType, StringType}

object ReadTsv {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    val movieDF = spark.read.option("delimiter", "\t").csv( "src/main/resources/sample.tsv")
      .toDF()
      .withColumnRenamed("_c0","wiki_mv_id")
      .withColumnRenamed("_c2","mv_nm")
      .withColumnRenamed("_c8","mv_genre")

    movieDF.show()
    //Datareader.readFromTsv is a helper function to read TSV file ,takes sparkSession and
    // file path as input to resurn a dataframe, which uses sparkSession's read function

//    movieDF.select(.as("mv_genre_map"))
//    movieDF.select(col("mv_genre"),get_json_object(col("mv_genre"), "$./m/02kdv5l").as("mv_genre_map"))
      //
//      .withColumn("genre_frmttd", from_json(col("mv_genre"),MapType(StringType, StringType)))
//      .show(1,false)

    movieDF.select("wiki_mv_id","mv_nm","mv_genre")
      .withColumn("genre_frmttd",map_values(from_json(col("mv_genre"),MapType(StringType, StringType))))
      .show(1,false)

  }

}
