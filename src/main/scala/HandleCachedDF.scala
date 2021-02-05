import org.apache.spark.rdd
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SaveMode, functions}

object HandleCachedDF {

  var cachedAnimalDF : rdd.RDD[String] = _
  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    val df = spark.read.json("src/main/resources/hugeTest.json") // Load your Dataframe
    spark.conf.set("spark.sql.files.maxRecordsPerFile",50000)

    /*val df1 = time[rdd.RDD[String]] {
      getAnimalName(df)
    }
    val resultList = df1.collect().toList
    val df2 = time{
      getAnimalName(df)
    }
    val resultList1 = df2.collect().toList
    println(resultList.equals(resultList1))*/

    df.write
//        .option("maxRecordsPerFile",50000)
        .mode(SaveMode.Overwrite)
      .json("src/main/resources/hugeTestOutput")

  }

  def getAnimalName(dataFrame: DataFrame): rdd.RDD[String] = {
    if (cachedAnimalDF == null) { // Check if this the first initialization of your dataframe
      cachedAnimalDF = dataFrame.select("animal").
        filter(functions.col("animal").isNotNull && col("animal").notEqual("")).
        rdd.map(r => r.getString(0)).distinct().cache() // Cache your dataframe
    }
    cachedAnimalDF // Return your cached dataframe
  }

  def time[R](block: => R): R = { // COmpute the time taken by function to execute
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

}
