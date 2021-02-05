object GroupBy {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val df = List(Bean3(10,20,122,"0004","COD1","2006-11-04",150.0),
      Bean3(10,20,122,"0004","COD1","2006-11-04",300.0),
      Bean3(10,20,122,"0005","COD2","2012-10-17",100.0),
      Bean3(10,20,122,"0006","COD3","2015-12-05",500.0)
    ).toDF
    val groupByCol = df.columns.diff(Array("id", "amount"))
    df.groupBy("id",groupByCol: _*).sum("amount")
      .withColumnRenamed("sum(amount)","amount")
      .orderBy("cod")
      .show()
  }

}

case class Bean3(id : Int,cent : Int,prod: Int,contr : String,cod : String,date : String,amount : Double)
