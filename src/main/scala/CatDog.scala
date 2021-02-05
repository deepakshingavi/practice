import org.apache.spark.sql.Row

object CatDog {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(("cat", "3-3", "78-b"),
      ("cat", "3-3", "89-0"),
      ("cat", "4-4", "78-n"),
      ("dog", "4-4", "89-b")).toDF("a", "b", "c")

    //    df.show()

    //Write your out as JSON
    /*df.select("a").distinct().map((a: Row) =>
      (a, df.filter(col("a") === a).map(row => parseDF(row)))
    ).foreachPartition(iterator => {
      iterator.foreach(record => {
        val aVal = record._1.getString(0)
        record._2.write
          .json(s"src/main/resources/$aVal.json")
      })
    })*/

  }

  //Row mapping logic
  def parseDF(row: Row): Map[String, Map[String, String]] = {

    val b = row.getString(1)
    val c = row.getString(2)
    Map(b -> Map("b" -> b, "c" -> c))

  }

}
