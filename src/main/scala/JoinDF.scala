import org.apache.spark.sql.functions._

object JoinDF {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    import spark.implicits._
    var df1 = List(1, 2, 3, 4, 5, 6, 7, 8, 0).toDF("col1")  // 1st Dataframe
    var df2 = List(3, 0, 0, 4, 2, 6, 1, 0, 0).toDF("col2")  // 2nd Dataframe

    df1 = df1.withColumn("id", monotonically_increasing_id())  // Add row num to 1st DF
    df2 = df2.withColumn("id", monotonically_increasing_id())  // Add row num to 2nd DF


    var df3 = df2.join(df1, df1("id") === df2("id"))    // perform inner join
      .drop("id")  // drop the id column
      .withColumn("eval", when($"col1" === $"col2", $"col2")  // if equal assign col2
        .otherwise(
          when( $"col2" === lit(0), 1)  // if col2 is 0 assign 1
            .otherwise($"col2")                          // else set to col2
        ))

    val df2ColumnList = df2.columns
     df3 = df1.join(df2, df1("id") === df2("id"))
      .drop(df2ColumnList : _*)


  }

}
