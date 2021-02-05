import org.apache.spark.sql.functions._

object ExplodeArrauy {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(bean57("1",Array(bean55("aaa",2),bean55("aaa1",21))),
      bean57("2",Array(bean55("bbb",3),bean55("bbb3",31)))).toDF

    df
      .withColumn("status",col("subEntities").getField("status"))
      .withColumn("subEntityId",col("subEntities").getField("subEntityId"))
      .show()

  }

}


case class bean57(id:String,subEntities:Array[bean55])

case class bean55(status: String,subEntityId:Long)
