import java.util.Date

object DropDuplicateColumns {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
//    val targetDf=spark.read.parquet("targetLocation")
    import spark.implicits._
    val df1= List(CustomBean(1,new Date().toString,"")).toDF()//spark.sql("select * from sourceDf")
    val df2=List(CustomBean(2,new Date().toString,"")).toDF()//spark.sql("select * from targetDf")
    /*
    for loop over a date range to dedup and write the data to s3
    union dfs and run a dedup logic, have omitted dedup code and for loop
    */
    val df3=df1.union(df2)//spark.sql("select data_id,schedule_dt from df1 union all select data_id,schedule_dt from df2")
    df3.write.partitionBy("data_id", "schedule_dt").parquet("src/main/resources/unionDfs")
  }
}

case class CustomBean(data_id : Long,schedule_dt : String,comment : String)
