object SubtractRDD {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    val list1 = List(("keyA",5),("keyB",10))
    val list2 = List(("keyA",3),("keyB",7))
    val rdd1= spark.sparkContext.parallelize(list1)  // convert list to RDD
    val rdd2= spark.sparkContext.parallelize(list2)

    val result = rdd1.join(rdd2)  // Inner join RDDs
      .map(x => (x._1, x._2._1 - x._2._2 ))  // Combiner function for RDDs
      .collectAsMap()  // Collect result as Map
    println(result)
  }

}
