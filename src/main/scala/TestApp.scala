import org.apache.spark.SparkConf
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{MapType, StringType}

object TestApp {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("Loading Data").setMaster("local[*]")

    val spark = org.apache.spark.sql.SparkSession
      .builder
      .config(sparkConf)
      .appName("Test")
      .getOrCreate()

    val json = "[{\"resource_serialized\":\"{\\\"createdOn\\\":\\\"2000-07-20 00:00:00.0\\\",\\\"genderCode\\\":\\\"0\\\"}\",\"id\":\"00529e54-0f3d-4c76-9d3\"}]"

    import spark.implicits._
    val df = spark.read.json(Seq(json).toDS)

    val jsonColumn = from_json($"resource_serialized", MapType(StringType, StringType))
    val keysDF = df.select(explode(map_keys(jsonColumn))).distinct()
    val keys = keysDF.collect().map(f=>f.get(0))
    val keyCols = keys.map(f=> jsonColumn.getItem(f).as(f.toString))
    df.select( $"id" +: keyCols:_*).show(false)

  }
}