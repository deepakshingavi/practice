import org.apache.spark.sql.{SparkSession, functions}

object ExplodeColumn {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local[*]").getOrCreate

    import spark.implicits._
    val df = List(Array("1", "2", "3")).toDF()
    df.show()
    df.withColumn("exploded", functions.explode_outer($"value")).show()

    val config = List((Array("a", "b", "c"), ("first")),
      (Array("d", "e"), ("second")),
      (Array("f"), ("third"))).toDF(List("col1", "col2"): _*)

    /*config.foreachPartition(f => {
      f.grouped(10000).foreach( (roqSeq : Seq[Row]) => {

        roqSeq.foreach( row => {
          /*producer.send(new Nothing("topicName", row.getAs("keyCol"), row.getAs("valCol")), new Nothing() {
            def onCompletion(recordMetadata: Nothing, e: Exception): Unit = {
              //Callback code goes here
            }
          })*/
        })
          Thread.sleep(60000)
        }
      )
    })*/

    config.withColumn("exploded", functions.explode_outer($"col1")).drop("col1").show()

  }

}
