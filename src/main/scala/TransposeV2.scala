import org.apache.spark.sql.functions._

object TransposeV2 {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    val list = List("a", "b", "c", "d")

    import spark.implicits._

    val df = list.toDF("id")

    df.show()

    import spark.implicits._

    val transpose = list.zipWithIndex.map {
      case (_, index) => {
        col("data").getItem(index).as(s"col_${index}")
      }
    }

    df.select(collect_list($"id").as("data")).select(transpose: _*).show()

    val dfInterim = df.filter($"id" =!="a" )
    val finalElements : Int = dfInterim.count().toInt
    dfInterim.select(collect_list($"id").as("data")).select(transpose.take(finalElements): _*).show()
  }

}
