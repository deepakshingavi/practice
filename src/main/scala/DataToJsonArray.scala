import org.apache.spark.sql.DataFrame

object DataToJsonArray {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df : DataFrame = List(
      ("Freeform", "59bbe3ad-f487-44", "htvjiwmfe", "1589155200000", "1591272659556","xyz"),
      ("D23", "59bbe3ad-f487-44", "htvjiwmfe", "1589155200000", "1591272659556","xyz"),
      ("Stores", "59bbe3ad-f487-44", "htvjiwmfe", "1589155200000", "1591272659556","xyz"),
      ("VacationClub", "59bbe3ad-f487-44", "htvjiwmfe", "1589155200000", "1591272659556","xyz")
    ).toDF

    //Load you dataframe
    val requestDetailArray  = df
      //Map your Dataframe to RequestDetails bean
      .map(row => RequestDetails(row.getString(0), row.getString(1), row.getString(2), row.getString(3), row.getString(4)))
      //Collect it as Array
      .collect()

    //Create another data frme with List[BaseClass] and set the (testname,Array[RequestDetails])
    /*List(BaseClass("xyz", requestDetailArray)).toDF()
      .write
      //Output your Dataframe as JSON
      .json("/json/output/path")*/



    /*List(df).map(row => {
      val df = row.getAs[DataFrame](0)
      println(df)
    })*/
  }

}

case class RequestDetails(Name: String, id: String, request_id: String, create_timestamp: String, deadline_timestamp: String)

case class BaseClass(testname: String = "xyz", systemResponse: Array[RequestDetails])
