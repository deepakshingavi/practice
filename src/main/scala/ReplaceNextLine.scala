import org.apache.spark.sql.functions

object ReplaceNextLine {


  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._
    val df = List((1,"anc\nxyz",28)).toDF("id","name","age").toDF
        .withColumn("name",functions.regexp_replace(functions.col("name"),"\n"," "))

    df.show()

  }

}
