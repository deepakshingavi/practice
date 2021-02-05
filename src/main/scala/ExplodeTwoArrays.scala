import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema

import scala.collection.mutable

object ExplodeTwoArrays {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = Seq((
      "1", Seq(4, 5, 6),
      Seq(Area("07:00", "07:30", "70"), Area("08:00", "08:30", "80"), Area("09:00", "09:30", "90"))
    )).toDF("id", "before", "after")
    val outDf = df.map(row=> {
      val id = row.getString(0)
      val beforeArray : Seq[Int]= row.getSeq[Int](1)
      val afterArray : mutable.WrappedArray[Area2] =
        row.getAs[mutable.WrappedArray[GenericRowWithSchema]](2) // Need to map Array(Struct) to the something compatible
          .zipWithIndex   // Require to iterate with indices
          .map{ case(element,i) => {
          Area2(element.getAs[String]("start_time"),
            element.getAs[String]("end_time"),
            element.getAs[String]("area"),
            beforeArray(i))
        }}
      (id,afterArray)   // Return row(id,Array(Area2(...)))
    }).toDF("id","after")

    outDf.printSchema()

    outDf.show()

  }

}

case class Area(start_time: String, end_time: String, area: String)

case class Area2(start_time: String, end_time: String, area: String, before: Int)
