import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession, functions}

object CaseSensitive {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").getOrCreate()
    spark.conf.set("spark.sql.caseSensitive","true")
    val df : DataFrame = spark.read.json("src/main/resources/test.json")

    //Order the column names as you want
    val columns = Array("emp_id","name","gender","salary","superior_emp_id","year_joined","emp_dept_id")
        .map(col)

    //Pass it to select
    df.select(columns: _*)

    val finalColumns = df.columns.groupBy(_.toLowerCase)
      .map(t => functions.coalesce(t._2.map(col):_*).as(t._1))
      .toArray
    df.select(finalColumns: _*).show()






//    val peopleArray : Array[Map[String,Any]] = df.collect.map(r => Map(df.columns.zip(r.toSeq):_*))
  }
}
