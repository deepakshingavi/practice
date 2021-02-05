import org.apache.spark.sql.{SaveMode, functions}

object GenerateTenMils {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    spark.conf.set("spark.sql.crossJoin.enabled","true") // Enable cross join
    import spark.implicits._

    //Create a DF with your sentence
    val df = List("each line has the same sentence").toDF

    //Create another Dataset with 10000000 records
    spark.range(10000000)
      .join(df)    // Cross Join the dataframes
      .coalesce(1)  // Output to a single file
      .drop("id")       // Drop the extra column
      .write
      .mode(SaveMode.Overwrite)
      .text("src/main/resources/tenMils") // Write as text file
  }

  val customUDF = functions.udf((array: Seq[String]) => {
    val newts = array.filter(_.nonEmpty)
    if  (newts.size == 0) null
    else newts.head
  })

}
