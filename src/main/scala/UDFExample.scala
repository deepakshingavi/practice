import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, DataFrame}

object UDFExample {

  def d_idt(d1: Column) =  concat(substring(d1,4,2),year(to_date(from_unixtime(unix_timestamp(d1,"dd-MM-yyyy")))))

//  def d_idt(d1: String) =  "".concat(d1.substring(4,6),year(to_date(from_unixtime(unix_timestamp(d1,"dd-MM-yyyy")))))

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    /*
        import spark.implicits._
        val df : DataFrame = List("1970-01-01 00:00:00").toDF()
        df.createTempView("mytable")
        val sqlContext = spark.sqlContext
        sqlContext.udf.register("dc",d_idt _)
        sqlContext.sql("select dc(value) as simple from mytable").show*/
    val df : DataFrame = spark.sql("select dc(value) as simple from mytable")




  }




}
