import org.apache.spark.sql.functions._

import scala.collection.mutable

object PerCount {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List((1, 3, 11, 15, 3, 70, 80, 150, 20),
      (2, 19, 5, 15, 3, 150, 80, 200, 43),
      (3, 30, 15, 15, 39, 55, 80, 150, 200),
      (4, 8, 65, 3, 3, 70, 80, 150, 55)
    ).toDF("ID", "1_count", "2_count", "3_count", "4_count", "1_per", "2_per", "3_per", "4_per")

    val countArrayColumns = List("1_count", "2_count", "3_count", "4_count")
    val perArrayColumns = List("1_per", "2_per", "3_per", "4_per")

    df.withColumn("countArr", array(countArrayColumns.map(col): _*))
      .withColumn("perArr", array(perArrayColumns.map(col): _*))
      .map(row => {
        val countArr = row.getAs[mutable.WrappedArray[Int]]("countArr")
        val perArr = row.getAs[mutable.WrappedArray[Int]]("perArr")

        val (position, count, per) = countArr.zipWithIndex
          .filter(row => row._1 > 10 && perArr(row._2) < 100)
          .map(row => (row._2 + 1, row._1, perArr(row._2)))
          .headOption.getOrElse((0, 0, 0))

        (row.getInt(0), count, per, position)
      }).toDF("ID", "count", "per", "slot")
      .show()

  }

}
