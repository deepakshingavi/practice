import java.text.SimpleDateFormat
import java.util.Calendar

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object AddTimeStampColumns {

  def main(args: Array[String]): Unit = {
//    tempMethod
    funcc
  }

  private def tempMethod = {
    val now = Calendar.getInstance()
    now.set(Calendar.HOUR_OF_DAY, 0)
    now.set(Calendar.MINUTE, 0)
    now.set(Calendar.SECOND, 0)
    val colSeq = for (_ <- 0 to 4) yield {
      val colName = new SimpleDateFormat("HH:mm:ss").format(now.getTime)
      now.add(Calendar.SECOND, 1)
      StructField(colName, StringType)
    }
    //    (1 to 4) map(_ => new SimpleDateFormat("HH:mm:ss").format(timeSt)).

    val dfSchema = StructType(colSeq)
    val spark = Constant.getSparkSess
    val df: DataFrame = null //spark.createDataFrame(sc.emptyRDD[Row], schema)

    import spark.implicits._

    val dataset1 = List("abs").toDS()
    val dataset2 = List("xyz").toDS()
    dataset1.union(dataset2)
  }

  def funcc{
    val exMap = Map("k" -> Map("kate" -> 34),"a" -> Map("abe" -> 31))
    exMap.map{
      case ( k :String,v : Map[String,Int]) => println(
        v //  Map("kate" -> 34) , Map("abe" -> 31)
          .map(
            _._2 // 34, 31
          )
          .foreach(println(_))
        //place to retrieve each element and perform action over it
      )
    } // by default map will collect all the returning value to a single list
  }

}
