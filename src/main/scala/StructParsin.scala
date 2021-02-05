import org.apache.spark.sql.functions._

object StructParsin {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess
    import spark.implicits._

    val df = List(
      Apartment(Array(Element("ABC ABC","123"),Element("XYZ ABC","123")),"ABC ABC"),
      Apartment(Array(Element("DEF","123"),Element("DEF1","123")),"XYZ")
    )
      .toDF

    df.show()


    df.printSchema()
    df.withColumn("address",
      expr("filter(address, x -> ( x.streetName != streetName AND x.streetName != 'Secondary' ))"))
      .show()
//    entityJoinB_df.withColumn("address",
//      expr("filter(addressstructm.address, x-> x.streetName!=streetName )"))
  }
}

case class Element (streetName: String,city:String)

case class Apartment(address: Array[Element],streetName:String)
