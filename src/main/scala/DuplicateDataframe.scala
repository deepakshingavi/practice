object DuplicateDataframe {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._

    val df = List(PersonCity(1,"Ali","lhr")).toDF()
    val someDF = df.limit(0).union(List(PersonCity(4,"Ahmad","sw1")).toDF())
  }
}

case class PersonCity(Id : Int,Name : String,City :String )