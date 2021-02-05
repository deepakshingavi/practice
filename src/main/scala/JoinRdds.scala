import org.apache.spark.sql.functions._

import scala.collection.mutable

object JoinRdds {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    import spark.implicits._
    var df1 = List((2,5),(3,7)).toDF("x","y")  // 1st Dataframe
    val df2 = List((0,List(5,7)), (1,List(2,4))).toDF("id", "coordinates")  // 2nd Dataframe

    df1 = df1.withColumn("id", monotonically_increasing_id())  // Add row num to 1st DF
//    df2.join(df1, df1("id") === df2("id"))    // perform inner join
//      .drop("id")  // drop the id column
//      .show(false)

    val rdd = df2.join(df1, df1("id") === df2("id")).rdd  // here's your RDD you can
    val resultCoordinates : Array[(Int, Int)] = rdd.map(row => { // Iterate the result row by row
      // you can do all sort of operations per row return any type here.
      val coordinates = row.getAs[mutable.WrappedArray[Int]]("coordinates")
      val x = row.getAs[Integer]("x")
      val y = row.getAs[Integer]("y")
      (coordinates(0) - x , coordinates(1) - y )
    }).collect() // the collect call on the output
    resultCoordinates.foreach(r => println(s"(${r._1},${r._2})")) // printing the output result
  }

}
