import org.apache.spark.sql.{SparkSession}
import org.apache.spark.sql.functions._

object WhenThenExample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
    val df = List(Array(1, 2, 3, 4)).toDF()
    val c = $"value"
    df.withColumn("new_col",when(size(c) === lit(4), c.getItem(2)).
      when(size(c) === lit(2), c.getItem(1)).
      when(size(c) === lit(0), lit(0)).otherwise(lit(-100))).show()
  }
}
