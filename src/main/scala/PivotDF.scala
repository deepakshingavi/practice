import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._

object PivotDF {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._
    val df = List(
      CountryInfo("beans",  496,   200,   210,  234,119),
      CountryInfo("banana",  -1,   345,   234,  123,122)/*,
      CountryInfo("strawberry",  496,   200,   210,  234,119),
      CountryInfo("mango",  496,   200,   210,  234,119),
      CountryInfo("chiku",  496,   200,   210,  234,119),
      CountryInfo("apple",  496,   200,   210,  234,119)*/
    ).toDF()

    val unPivotDF = df.select($"product",$"german",
      expr("stack(4, 'china', china, 'usa', usa, 'france', france,'india',india) " +
      "as (Country,Total)"))
    unPivotDF.show()

    val fixedCol : List[Column] = List(col("german") , col("product") , expr("stack(.......)"))
    df.select(fixedCol:_*) //it gives error as first argument of select is fixed and second arg is varargs

    val v : Seq[Int] = "".tails.zipWithIndex.toSeq.sortBy(_._1).map(_._2)
  }

}

case class CountryInfo( product: String, china: Int, france: Int, german: Int, india: Int, usa: Int)
