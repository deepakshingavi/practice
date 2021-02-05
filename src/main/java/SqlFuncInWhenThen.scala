import org.apache.spark.api.java.JavaRDD
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object SqlFuncInWhenThen {



  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local[*]").getOrCreate
    import spark.implicits._
    val df : DataFrame= Seq("").toDF
    val newdf = df.withColumn("asc", ascii($"text"))
      .withColumn("language", when(col("asc") > 0, "en")
        .otherwise(col("hi")))



    val vgdataLines = spark.sparkContext.textFile("hdfs:///user/ashhall1616/bdc_data/t1/vgsales-small.csv")
    val vgdata = vgdataLines.map(_.split(";"))

    def toPercentage(x: Double): Double = {x * 100}
    val countPubl : DataFrame  = vgdata.map(r =>  (r(4),1)).reduceByKey(_+_).toDF()
    val javaRdd : JavaRDD[Row] = countPubl.withColumn("",col("")).toJavaRDD


//    newdf = df.withColumn('Total', sum(df[col] for col in df.columns.remove("salesperson")))

//     df.withColumn('Total', sum())
  }



}
