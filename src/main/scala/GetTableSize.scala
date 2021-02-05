import org.apache.spark.sql.functions._

object GetTableSize {

  def main(args: Array[String]): Unit = {

    //Get Spark Sql table size

    val spark = Constant.getSparkSess
    /**
     * file content
     * spark-test-data.json
     * --------------------
     * {"id":1,"name":"abc1"}
     * {"id":2,"name":"abc2"}
     * {"id":3,"name":"abc3"}
     */
    val fileName = "spark-test-data.json"
    val path = getClass.getResource("/" + fileName).getPath

    spark.catalog.createTable("df", path, "json")
      .show(false)

    /**
     * +---+----+
     * |id |name|
     * +---+----+
     * |1  |abc1|
     * |2  |abc2|
     * |3  |abc3|
     * +---+----+
     */
    // Collect only statistics that do not require scanning the whole table (that is, size in bytes).
    spark.sql("ANALYZE TABLE df COMPUTE STATISTICS NOSCAN")
    spark.sql("DESCRIBE EXTENDED df ").filter(col("col_name") === "Statistics").show(false)

    /**
     * +----------+---------+-------+
     * |col_name  |data_type|comment|
     * +----------+---------+-------+
     * |Statistics|68 bytes |       |
     * +----------+---------+-------+
     */
    spark.sql("ANALYZE TABLE df COMPUTE STATISTICS")
    spark.sql("DESCRIBE EXTENDED df ").filter(col("col_name") === "Statistics").show(false)

    /**
     * +----------+----------------+-------+
     * |col_name  |data_type       |comment|
     * +----------+----------------+-------+
     * |Statistics|68 bytes, 3 rows|       |
     * +----------+----------------+-------+
     */
  }

}
