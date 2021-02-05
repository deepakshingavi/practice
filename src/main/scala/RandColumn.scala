import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DataTypes

object RandColumn {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._


    val df = List(("Ford","Y"),("Ford","Y"),
      ("Caddilac","Y"),("Caddilac","Y")
    ).toDF("source","live")

    df
      .withColumn("category",when( ( (rand()*100) % 2).cast(DataTypes.IntegerType) === 0,"Business")
      .otherwise("Casual"))
      .drop("randomNo")
      .show()
  }

}
