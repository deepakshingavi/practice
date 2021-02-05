

object LoadTimeForADF {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    val timetaken = time {
      spark.read
        .format("jdbc")
        .option("url", "drivingUrl")
        .option("dbtable", "drivingQuery")
        .option("driver", "driver")
        .load();
    }
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }


}
