import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import java.util.ArrayList

import scala.io.Source;

object InnerJoin {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    import spark.implicits._

    val df1 = List(
      ("A011021", "15", "2020-01-01", "2020-12-31", "4"),
      ("A011021", "15", "2020-01-01", "2020-12-31", "4"),
      ("A011021", "15", "2020-01-01", "2020-12-31", "4"),
      ("A011021", "15", "2020-01-01", "2020-12-31", "3"),
      ("A011022", "6" , "2020-01-01", "2020-12-31", "3"),
      ("A011022", "6" , "2020-01-01", "2020-12-31", "3"))
      .toDF("rep_id","sales_target","start_date","end_date","st_new")
      .withColumn("rowid",monotonically_increasing_id())

    val df2 = List(
      ("A011021","15","2020-01-01","2020-12-31","2020-01-01","2020-03-31"),
      ("A011021","15","2020-01-01","2020-12-31","2020-04-01","2020-06-30"),
      ("A011021","15","2020-01-01","2020-12-31","2020-07-01","2020-09-30"),
      ("A011021","15","2020-01-01","2020-12-31","2020-10-01","2020-12-31"),
      ("A011022","6" ,"2020-01-01","2020-06-30","2020-01-01","2020-03-31"),
      ("A011022","6" ,"2020-01-01","2020-06-30","2020-04-01","2020-06-30"))
      .toDF("rep_id","sales_target","start_date","end_date","new_sdt","new_edt")
      .withColumn("rowid",monotonically_increasing_id())


    df1.as("ds1").join(df2.as("ds2"),
      col("ds1.rowid") === col("ds2.rowid"),
      "inner")
      .orderBy(col("ds1.rep_id"),col("ds1.sales_target"),col("st_new").desc)
      .drop("rowid")
      .show()

    val dfList : List[DataFrame] = null

    val dfMap : Map[String,DataFrame] = dfList.map("some_name" -> _).toMap

    val filename = "/mnt/jomount/ProductDetails.csv"
    Source.fromFile(filename)
  }

}
