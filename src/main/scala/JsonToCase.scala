import org.apache.spark.sql.{Dataset, Encoders}
import org.apache.spark.sql.functions._

object JsonToCase {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val schema = Encoders.product[Bean44].schema

    var df = List("""{"brand":"hortense","category":"clothing","description":"Hortense B. Hewitt 25027 Peplum Garter Set","mode":"dinner's club","orditems":"2","productcode":"8f6e9f55-c69d-4b2c-a249-572b4e53fa9a","unitprice":"3360"}""").toDF("value")
    df = df.withColumn("data",from_json(col("value"),schema))
    val mappedTOBean: Dataset[Bean44] = df.select("data.*").as[Bean44]
    mappedTOBean.show()

    var inputDf = Seq(
      (1, "Mr"),
      (1, "Mme"),
      (1, "Mr"),
      (1, null),
      (1, null),
      (1, null),
      (2, "Mr"),
      (3, null)).toDF("UNIQUE_GUEST_ID", "PREFIX")
    println("Input:")
    inputDf = inputDf
        .filter(col("PREFIX").isNotNull)

    inputDf
      .groupBy($"UNIQUE_GUEST_ID",$"PREFIX")
      .count()
      .show()

  }

}

case class Bean44(brand:String,category:String,description:String,mode:String,orditems:String,productcode:String,unitprice:String)
