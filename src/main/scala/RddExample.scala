import org.apache.spark.rdd

object RddExample {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    val sc = spark.sparkContext
//    import spark.implicits._
    val dataArray = Array("a,1|2|3","b,4|5|6","a,7|8|9","b,10|11|12")

    val dataRDD = sc.parallelize(dataArray)

    val mapRDD : rdd.RDD[(String, Array[Int])] = dataRDD.map(rec => (rec.split(",")(0),rec.split(",")(1)
      .split("\\|").map(_.toInt)))

//    val mapRdd : Array[(String, Array[String])] = mapRDD.collect

    val result : Array[(String, List[Int])] =  mapRDD.groupByKey().mapValues(itr => {
      itr.toList.transpose.map(_.sum)
    }).collect()
    println(result)



  }

}
