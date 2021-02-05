import org.apache.spark.sql.streaming.{OutputMode, Trigger}

object ReadSocket {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    //Start reading from socket
    val dfStream = spark.readStream
      .format("socket")
      .option("host","127.0.0.1") // Replace it your socket host
      .option("port","9090")
      .load()

    dfStream.writeStream
      .trigger(Trigger.ProcessingTime("1 minute")) // Will trigger 1 minute
      .outputMode(OutputMode.Append) // Batch will processed for the data arrived in last 1 minute
      /*.foreachBatch((ds,id) => { //
        ds.foreach(row => { // Iterdate your data set
          //Put around your File generation logic
          println(row.getString(0)) // Thats your record
        })
      }).start().awaitTermination()*/
  }

}
