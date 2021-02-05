import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object ArrayToColumns {

  def main(args: Array[String]): Unit = {

    val spark : SparkSession = Constant.getSparkSess

    val df1 = spark.read.csv("<>")
      .toDF()

    df1.select("")
      .show(); //

//    I have some problem with my system mic


    import spark.implicits._

    val df = List( (1,"20-Mar"),(1,"30-Mar"),(1,"20-Mar"),
      (2,"10-Mar"),(2,"12-Mar"),
      (3,"20-Mar"),
      (4,"20-Mar"),(4,"09-Mar")
    )
      .toDF("ID","Date")

    val dfNew = df.groupBy("ID")
      .agg(collect_list("Date").as("DateArr"))

    val maxArraySize : Int = dfNew.select(max(size(col("DateArr")).as("ArraySize"))).head().getInt(0)

    dfNew
      .select(col("ID") +: (0 until maxArraySize).map(i => coalesce(col("DateArr")(i),lit("")).alias(s"Date_${i+1}")): _*)
      .show()

  }

}
