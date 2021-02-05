import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd

object RandomDF {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    val sc = spark.sparkContext
    val rand6 : rdd.RDD[Int] =sc.parallelize(List(1,2,3,4))
    val bv: Broadcast[List[Int]] =sc.broadcast(List(5,6,7,8))
    val output = rand6.map( (s : Int)=>{
      val c : List[Int] =List(1,2,3,4)
      val a = s :: c
//      val b = a.flatMap(r=>r)
//      b
      a
    }).collect().toList

    println(output)
  }

}
