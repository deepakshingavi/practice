import org.apache.spark.sql.{DataFrameReader, SparkSession}

object SparkJdbcMultipleTables {

  def main(args: Array[String]): Unit = {
    val tableNameList = Seq("table1,table2")
    val spark = SparkSession.builder.master("local[*]").getOrCreate
    val reader : DataFrameReader = spark.read.option("url", "jdbc:mysql://hostname/db?tinyInt1isBit=false")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "user")
        .option("password", "pass")
    tableNameList.map( _ => {
      reader.option("dbtable","tablename").load().createTempView(_) // views for all JDBC table in Spark SQL.
    })

  }

}
