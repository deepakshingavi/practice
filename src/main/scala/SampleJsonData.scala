import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SampleJsonData {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local[*]").getOrCreate;


    //Load your JSON
    val df = spark.read.json("src/main/resources/sampleJsonData.json")

    //Add a new Column with name "fullname"
    df.withColumn("fullname",
      //Select nested "firstname.s" and "secondname.s" and assign it to "fullname.s"
      struct(concat(col("firstname.s"),lit(" "),col("secondname.s")).as("s")))
      //Write your JSON output
      .write.json("src/main/resources/sampleJsonDataOutput.json")


  }

}
