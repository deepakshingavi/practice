object JoinRdds1 {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._

    spark.conf.set("spark.sql.crossJoin.enabled","true")

    val rdd1 = List(bean5(1)).toDF.toJavaRDD
    val rdd2 = List(bean6(1)).toDF.toJavaRDD

//    rdd1.join(rdd2).show()
  }

}

case class bean5(i:Int)
case class bean6(i:Int)
