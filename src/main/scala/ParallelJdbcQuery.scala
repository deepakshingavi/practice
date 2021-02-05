import org.apache.spark.sql.{Row, SparkSession}

object ParallelJdbcQuery {

  def updateTable(res: Array[Row], maybeString: Option[String]): Unit = ???

  def main(args: Array[String]): Unit = {
    val query1 = "select * from table1";
    val query2 = "select * from table2";
    val queries = Map(query1 -> "table1", query2 -> "table2")
    val spark = SparkSession.builder().master("local[*]").getOrCreate()
    spark.sparkContext.parallelize(queries.keys.toSeq).foreach(query => {
      val res = spark.sql(query).collect()
      updateTable(res, queries.get(query))
    })
  }

}
