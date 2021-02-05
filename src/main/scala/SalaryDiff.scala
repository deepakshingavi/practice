import org.apache.spark.sql.functions._

object SalaryDiff {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._

    val df1 = List(("1", "5000"), ("2", "3000"), ("3", "5000")).toDF("id", "salary") // First dataframe

    val df2 = List(("1", "3000"), ("2", "5000"), ("3", "5000")).toDF("id", "salary") // Second dataframe

    val df3 = df1
      .join(
        df2
        , df1("id") === df2("id")    // Join both dataframes on id column
      ).withColumn("finalSalary", when(df1("salary") < df2("salary"), df2("salary") - df1("salary")) // 5000-3000=2000 check
      .otherwise(
      when(df1("salary") > df2("salary"), df1("salary") + df2("salary"))  // 5000+3000=8000  check
        .otherwise(df2("salary"))))    // insert from second dataframe
      .drop(df1("salary"))
      .drop(df2("salary"))
      .withColumnRenamed("finalSalary","salary")
      .show()


    val df4 = df1.join(df2, df1("inv_num") === df2("inv_num")  // Join both dataframes on id column
    ).withColumn("finalSalary", when(df1("salary") < df2("salary"), df2("salary") - df1("salary"))
      .otherwise(
        when(df1("salary") > df2("salary"), df1("salary") + df2("salary"))  // 5000+3000=8000  check
          .otherwise(df2("salary"))))    // insert from second dataframe
      .drop(df1("salary"))
      .drop(df2("salary"))
      .withColumnRenamed("finalSalary","salary")
      .show()

  }

}
