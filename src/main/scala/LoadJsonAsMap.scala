import org.apache.spark.sql.types.{DataTypes, StringType}

object LoadJsonAsMap {


  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    //    val js = Seq("""{"1": "a", "2": "b","3":"c","4":"d","5":"e"}""").toDS

    val schema = DataTypes.createMapType(StringType,StringType)

    val df = spark
      .read
//        .schema(schema.toString)
      .option("multiline", "true")
      .json("src/main/resources/sample1.json")

    val stack = s"""stack(${df.columns.flatMap(c => Seq(s"'${c}'",s"`${c}`")).mkString(",")}) as (id,name,temp)"""
//    println(stack)
//    df.select(functions.expr(stack)).show(false)
    df.createTempView("df")
    spark.sql(s"""select * from df where "26" NOT IN "z"  """).show(false)

  }

}
