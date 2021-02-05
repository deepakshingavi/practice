import org.apache.spark.sql.functions._

object RowNum {


  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val df = List((1,1),(1,1),(1,2),(2,1),(2,2),(2,3)).toDF().select("*").withColumn("id",monotonically_increasing_id())
    df.show()
    var aggDf = df.groupBy("_1","_2")
      .agg(
         collect_list("id").as("idArray"))   // also group the element by row ids

     aggDf = df.groupBy("_1","_2")
      .agg(max("id"),min("id"))

    // join the raw df with aggregated df and check if the id column has the minimum value


    var name="abcd"

    val df3 = df.join(df, df("id") === df("id"))
      .filter(df("name")===name && df("name")===name)
      .drop(df("name"))
      .drop(df("name"))

    //have kept id ,
//    aggDf.printSchema()

  }

  def minUdf = udf((arr: Seq[String])=> arr.filterNot(_ == "").map(_.toInt).min)

}
