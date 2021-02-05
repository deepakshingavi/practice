import org.apache.spark.rdd
import org.apache.spark.sql.SaveMode

object KryoDeserliazer {

  def main(args: Array[String]): Unit = {
    /*val conf = new SparkConf()
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.kryo.registrationRequired", "true")
      .registerKryoClasses(Array(classOf[SampleBean], classOf[InternalRow]
        , classOf[Array[InternalRow]]
        , classOf[WriteTaskResult]
        , classOf[FileCommitProtocol.TaskCommitMessage]
        , classOf[ExecutedWriteSummary],
        classOf[BasicWriteTaskStats]))

    val spark = SparkSession.builder.master("local[*]")
      .config(conf)
      .getOrCreate

    import spark.implicits._
    val df = List(SampleBean("A", "B")).toDF()
    df.write.mode(SaveMode.Overwrite).json("src/main/resources/kryoTest")
    df.printSchema()*/

    val sparkNew = Constant.getSparkSess
    val dfNew = sparkNew.read.json("src/main/resources/serialisedJavaObj.json").toDF()
//    headerDf.coalesce(1).write.mode(SaveMode.Append).text("file:///home/ubuntu/filerJson") // write your header here
    dfNew.coalesce(1).write
      .partitionBy()
      .mode(SaveMode.Append).text("file:///home/ubuntu/filerJson") // write your JSOn body
//    footerDf.coalesce(1).write.mode(SaveMode.Append).text("file:///home/ubuntu/filerJson") // write your footer here
    dfNew.printSchema()
    val data : rdd.RDD[_] = null

  }

}

case class SampleBean(field1: String, field2: String)
