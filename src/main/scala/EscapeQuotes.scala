import org.apache.spark.sql.functions._

object EscapeQuotes {
  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    val pattern = "“|”"
    spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .option("quote", "\"")
      .option("escape", "\"")
      .csv("src/main/resources/sample.csv")
      .withColumn("eloc",regexp_replace(col("eloc"),pattern,""))
      .withColumn("ename",regexp_replace(col("ename"),pattern,""))
      .show()


    val columns = List("PK","Col1","Col3","A","ColD","C","ColC")
    spark.read.csv("File1","File2","File3").select(columns.map(col):_*)
  }

}
