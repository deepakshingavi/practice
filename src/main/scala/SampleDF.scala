import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SampleDF {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder.master("local[*]").getOrCreate;
    import spark.implicits._
    val inputDf = Seq((1,"G K","0 "),
      (2,"L-L","1"),
        (3,null,"  1")).toDF("sno","dept","color")

    inputDf
      .withColumn("dept",regexp_replace($"dept"," |-",""))
      .withColumn("color",trim($"color"))
      .show()


  }

}
