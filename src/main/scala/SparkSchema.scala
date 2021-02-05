import java.io.FileWriter

object SparkSchema {

  def main(args: Array[String]): Unit = {

    val fw = new FileWriter("src/main/resources/csv.schema", true)
    fw.write("column_name,datatype\n")

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(("", "", "", 1l)).toDF("applicationName", "id", "requestId", "version")
    val columnList : List[(String, String)] = df.schema.fields.map(field => (field.name, field.dataType.typeName))
      .toList
    try {
      val outString = columnList.map(col => {
        col._1 + "," + col._2
      }).mkString("\n")
      fw.write(outString)
    }
    finally fw.close()

    val newColumnList : List[(String, String)] = List(("newColumn","integer"))

    val finalColList = columnList ++ newColumnList
    writeToS3("s3://bucket/newFileName.csv",finalColList)

  }

  def writeToS3(s3FileNameWithpath : String,finalColList : List[(String,String)]) {

    val outString =  finalColList.map(col => {
      col._1 + "," + col._2
    }).mkString("\\n")

    import org.apache.hadoop.fs._
    import org.apache.hadoop.conf.Configuration
    val conf = new Configuration()
    conf.set("fs.s3a.access.key", "YOUR ACCESS KEY")
    conf.set("fs.s3a.secret.key", "YOUR SECRET KEY")

    val dest = new Path(s3FileNameWithpath)
    val fs = dest.getFileSystem(conf)
    val out = fs.create(dest, true)
    out.write( outString.getBytes )
    out.close()
  }

}
