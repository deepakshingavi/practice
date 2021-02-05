import scala.collection.parallel._
import scala.collection.parallel.mutable.ParArray
object WriteDfInParallel {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    val query1 = "";
    val query2 = "";
    val driver,url,user,password = ""; // declare your db credentials
    val queries : ParArray[(String, String)] = mutable.ParArray((query1,"s3://bucket-name/test2"),  // Convert the Array to parallel array
      (query2,"s3://bucket-name/test1"))

    queries.tasksupport = new ForkJoinTaskSupport(ForkJoinTasks.defaultForkJoinPool)
    queries.foreach(query => {
      println(query)
    })
  }

}
