import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object ProcessSemiColonCsv {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    val schema = StructType( List(StructField("age", IntegerType, true),
      StructField("job", StringType, true) ,
      StructField("marital", StringType, true),
      StructField("education", StringType, true) ,
      StructField("default", StringType, true),
      StructField("balance", IntegerType, true) ,
      StructField("housing", StringType, true) ,
      StructField("loan", StringType, true) ,
      StructField("contact", StringType, true) ,
      StructField("day", IntegerType, true) ,
      StructField("month", StringType, true) ,
      StructField("duration", IntegerType, true) ,
      StructField("campaign", IntegerType, true) ,
      StructField("pdays", IntegerType, true) ,
      StructField("previous", IntegerType, true) ,
      StructField("poutcome", StringType, true) ,
      StructField("y", StringType, true)) )

    val df = spark.read
//      .option("sep","\t")
      .option("escape","\"")
      .option("delimiter", ";")
      .option("header", "true")
      .option("multiLine","true")
      //uncomment below line if your records are space separated

      .schema(schema)
      .csv("src/main/resources/SemiColon.csv")

    df.show()
//    df.printSchema()
  }

}
