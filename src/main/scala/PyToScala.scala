import org.apache.spark.sql.DataFrame

object PyToScala {



  def main(args: Array[String]): Unit = {

    val new_file1 : DataFrame = null
    val new_file2: DataFrame = null


    /*new_file2.collect().foldLeft(new_file1)((taxiDf : DataFrame,row:Row) => {

      val district = row.getAs[Float]("dis")
      val lon = row.getAs[Float]("lon")
      val lat = row.getAs[Float]("lat")
      val distance = row.getAs[Float]("r")
      val taxiLon = taxiDf.getAs[Float]("lon")
      val taxiLat = taxiDf.getAs[Float]("lat")
      if(cal_distance(lon,lat,taxiLon,taxiLat) <= distance) {
        temp+=1
      }
    })

    new_file2.foreach(row => {
      val district = row.getAs[Float]("dis")
      val lon = row.getAs[Float]("lon")
      val lat = row.getAs[Float]("lat")
      val distance = row.getAs[Float]("r")
      var temp = 0
      new_file1.foreach(taxi => {
        val taxiLon = taxi.getAs[Float]("lon")
        val taxiLat = taxi.getAs[Float]("lat")
        if(cal_distance(lon,lat,taxiLon,taxiLat) <= distance) {
          temp+=1
        }
      })
      println(s"district:${district} temp=${temp}")
    })*/
  }

  def cal_distance(lon: Float, lat: Float, taxiLon: Float, taxiLat: Float) : Float = {
    val distance = 0.0f
    // write your geopy scala code here
    distance
  }


}
