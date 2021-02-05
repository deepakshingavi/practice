import org.apache.spark.sql.SparkSession

object ConditionalSparkSess {

  @transient private var sparkSession: SparkSession = null

  def main(args: Array[String]): Unit = {
    val jsonStr = """{ "metadata": { "key": 84896, "value": 54 }}"""
    val spark = SparkSession.builder().appName("SparkExample").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    import spark.implicits._
    var df = spark.read.json(Seq(jsonStr).toDS)
    df.show()
  }



}
