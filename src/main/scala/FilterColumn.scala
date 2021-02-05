import org.apache.spark.sql.SparkSession

object FilterColumn {

  def main1(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
    val newDF = List(PersonCity(1,"lhr","")).toDF()
    newDF.show()
    val cols = newDF.columns
    val regex = """^((?!_index).)*$""".r
    val selection = cols.filter(s => regex.findFirstIn(s).isDefined)
    val finalCols = cols.diff(selection)
    val res =newDF.select(finalCols.head,finalCols.tail: _*)
    res.show()

  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .master("local[*]")
      .config("spark.sql.crossJoin.enabled","true")
//      .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .getOrCreate()


    /*var data = spark.read.option("header", "true")
      .option("inferSchema", "true")
      .csv("src/main/resources/student.csv")*/
    import spark.implicits._
    var data = List(PersonCity1("Ali","lhr",2.0,0.0)).toDF()

    val newRow: List[PersonCity1] = List(PersonCity1("DD","VVV",2.0,0.0))
    val df = newRow.toDF()
    data =data.except(data).union(df)
    data.show()

  }



}

case class PersonCity1(Name : String,   City :String, Name_index : Double,   City_index: Double)
