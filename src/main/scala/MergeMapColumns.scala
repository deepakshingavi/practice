import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions._

object MergeMapColumns {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    processDf1(spark)
//    processDf2(spark)
  }

  private def processDf2(spark:SparkSession): Unit = {
    import spark.implicits._
    val df = Seq(
      (1, Map("k1" -> "v1", "k2" -> "v3")),
      (1, Map("k3" -> "v3")),
      (2, Map("k4" -> "v4")),
      (2, Map("k6" -> "v6", "k5" -> "v5"))
    ).toDF("id", "data")

    val mergeExpr = functions.expr("aggregate(data, map(), (acc, i) -> map_concat(acc, i))")
    df.show()
    val addDf = df.groupBy("id").agg(collect_list("data").as("data"))
    addDf.show()
    addDf
      .select($"id", mergeExpr.as("merged_data"))
      .show(false)

  }

  private def processDf1(spark:SparkSession) = {
    import spark.implicits._
    val df1 = List(Bean4(List(Map("A" -> "B"), Map("B" -> "C")), Map("A" -> "B"))).toDF()
    df1.printSchema()
//    df1.withColumn("merged", mergeUdf($"mapList", $"map")).printSchema()
    df1.withColumn("merged", array_union($"mapList",array($"map"))).printSchema()
  }

  import org.apache.spark.sql.functions._
  def mergeUdf: UserDefinedFunction = udf((map1: List[Map[String, String]], map2: Map[String, String])=> map2 ++ map1)

}

case class Bean4( mapList : List[Map[String,String]], map : Map[String,String])
