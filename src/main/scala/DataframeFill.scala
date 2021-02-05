import org.apache.spark.sql.functions._

object DataframeFill {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._

    val personDF = Seq(("A", "B", 29, "M"),
      ("A", "C", 12, ""),
      ("B", "D", 35, "F"),
      ("Q", "D", 85, ""),
      ("W", "R", 14, "")).toDF("FName", "LName", "Age", "Gender")

    personDF.show()

    val finalResultWithHash = personDF.withColumn("ROWHASH", sha2(concat(personDF.columns.map(col): _*), 256))
    finalResultWithHash.show()

    /*personDF
    .withColumn("rowId", .monotonically_increasing_id())
      .withColumn("Gender_temp", when($"Gender".isin(""),
      when ($"rowId" % 2 ===0 ,"M").otherwise("F") ).otherwise($"Gender"))
      .drop("Gender")
      .drop("rowId")
      .withColumnRenamed("Gender_temp","Gender")
          .show()*/


  }

}
