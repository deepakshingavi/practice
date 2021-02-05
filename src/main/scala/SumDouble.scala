import org.apache.spark.sql.functions

object SumDouble {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List( (10.0,"User1") ).toDF("Amount","User")

    val sumDf = df.agg(functions.sum("Amount"))
    val sum = sumDf.collectAsList().get(0).getDouble(0)
    println(sum)
  }

}
