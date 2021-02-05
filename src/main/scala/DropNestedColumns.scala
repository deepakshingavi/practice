import org.apache.spark.sql.functions._

object DropNestedColumns {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(Bean10("1",Array(Bean11("1","now","active","later")))).toDF

    df.printSchema()


    val nestedDf = df.select(explode(col("webhooks")).as("webhooks"))
      .select("webhooks.*").columns
      .filter(_!="failed_at")
      .map(nestedCol => col(s"webhooks.${nestedCol}"))

    val columsExceptWebhooks = df.columns.filterNot(_ == "webhooks").map(col(_))

    df.withColumn("webhooks",explode($"webhooks"))
      .select((columsExceptWebhooks :+ array(struct(nestedDf:_*)).as("webhook")) :_*)
      .printSchema()
  }

}

case class Bean10(_id : String,webhooks:Array[Bean11])

case class Bean11(index:String,failed_at:String,status:String,updated_at:String)
