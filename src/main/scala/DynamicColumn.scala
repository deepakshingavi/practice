import org.apache.spark.sql.DataFrame

object DynamicColumn {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val df : DataFrame = List("ABC").toDF()

    val colNamesMap = Map("k" -> "k1","v" -> "v1")
    val newdf = colNamesMap.keys.foldLeft( df)((df : DataFrame,colOldName : (String)) => {
      df.withColumnRenamed(colOldName,colNamesMap.get(colOldName).get)
    })

    /*val dynamicCols : List[(String, Column)] = List(
      ("daysbetween",
         fn.datediff($"date1", $"date2")
      ),
      ("0", fn.when(
      $"daysbetween" >= -30,
      $"TotalPrice"
    )),
      ("-30", fn.when(
        $"daysbetween" >= -30,
        $"TotalPrice"
      )),
      ("-30",
        fn.when(
          $"daysbetween".between(-60, -31),
          $"TotalPrice"
        )),
      ("-60",
        $"".when(
          $"daysbetween".between(-90, -61),
          $"TotalPrice"
        )),
      ("<-90",
        fn.when(
          $"daysbetween" < -90,
          $"TotalPrice"
        ))
    )

    val df  = dynamicCols.foldLeft(df)((df : DataFrame,colInfo : (String,Column)) => {
      df.withColumn(colInfo._1,colInfo._2)
    }
    )*/

  }

}
