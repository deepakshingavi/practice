import org.apache.spark.sql.{Encoders, functions}

object MapToBean {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    val personEncoder = Encoders.bean[Bean56](classOf[Bean56])

    val df = spark.sql("""select map("foo", 1, "bar", 2) AS mapColumn""")
    df.printSchema()
    val Bean56s = df.map(row => {
      val map = row.getMap[String, Int](0)
      Bean56(map.getOrElse("foo", -1), map.getOrElse("bar", -1))
    })(personEncoder)

    Bean56s.withColumn("",functions.col(""))

    //    val jsonStr = df.withColumn("jsonized", to_json($"mapColumn")).select("jsonized").collect()(0)(0).asInstanceOf[String]

    //    spark.read.json(Seq(jsonStr).toDS()).show()
  }

}

case class Bean56(foo: Int, bar: Int)


