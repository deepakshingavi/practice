import org.apache.spark.sql.functions._

object AddExprColumn {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._

    val df = List(
      (1,1,1,1,3,"case when colA=1 and colB>0 then True else False end"),
      (2,2,3,4,4,"case when colD=1 then True else False end")
    ).toDF("colA", "colB", "colC", "colD", "colE","colCOND")

    val myExpression = "case when colCOND then True else False end"



    df
      .withColumn("colRESULT",expr( col("colCOND").toString())).show(false)

  }


}

case class A12()
