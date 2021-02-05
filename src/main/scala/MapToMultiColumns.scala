import org.apache.spark.sql.SparkSession

import scala.util.Try

object MapToMultiColumns {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder.master("local[*]").getOrCreate;

    import spark.implicits._

    val df = List("Maharashtra","23432.53","Karnataka","424244","Goa").toDF("columnvalues")

    df.map(row => {
      val isDouble = Try(row.getString(0).toDouble).isSuccess
      val value_number : Double = if(isDouble) row.getString(0).toDouble else 0.0
      val value_string : String = if(!isDouble) row.getString(0) else ""

      (row.getString(0),value_number,value_string)
    }).toDF("columnvalues","value_number","value_string")
      .show()

  }

}
