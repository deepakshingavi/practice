import org.apache.spark.sql.functions._

object ColToMap {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val sensorsDf = Seq(
      ("sensor1", 26, 30, 1000),
      ("sensor2", 25, 30, 1100),
      ("sensor3", 26, 30, 1000)
    ).toDF("sensor", "temperature", "humidity", "brightness")

    //Create a List of columns ready to be mapped
    val colToMap = List("temperature", "humidity", "brightness")
  .flatMap(colName =>  List(lit(colName) , col(colName) ))

    sensorsDf
      .withColumn("measures", map(colToMap: _ *)).show(false)
  }

}
