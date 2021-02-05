import org.apache.spark.sql.functions._

//2054908282ns with only sort
//6418125999ns with collect
//4389645843ns
//3529909582ns
//5629770998 + 6105480582 + 6140928693 + 5984625202 + 6010209858
//3843901868 + 3784007686 + 3719107624 + 3628069795 + 3660190782
import scala.collection.JavaConversions._

object SortBigDataSet {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._
    val r = new scala.util.Random(100)
    val df = time {

      //Create a list with size 1000000 of random nos.
      spark.sparkContext.parallelize(for (i <- 1 to 1000000) yield  r.nextInt(1000000) )
        .toDF // Convert oto dataframe with single column 'value'
        .sortWithinPartitions(col("value"))  // Sort the partition in parallel i.e. similair to sortin data on each worker
        .sort(col("value"))                  // Final sort on complete data set
        .map(r=>r.getInt(0)).collectAsList().toSeq // Colecting the result in list

    }
    println(df)
  }

  def time[R](block: => R): Unit = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def isSorted[T](s: Seq[T])(implicit ord: Ordering[T]): Boolean = s match {
    case Seq() => true
    case Seq(_) => true
    case _ => s.sliding(2).forall { case Seq(x, y) => ord.lteq(x, y) }
  }

}
