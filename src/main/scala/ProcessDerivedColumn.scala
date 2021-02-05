import org.apache.spark.sql.Row
import org.apache.spark.sql.functions._

object ProcessDerivedColumn {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(SimpleBean(1,"","2.0"),SimpleBean(2,"","4.0"),SimpleBean(3,"","6.0"),
      SimpleBean(4,"3.0","")).toDF("id","d1","d2")

    val sumD2 = df.agg(sum("d2")).first().getDouble(0)
    val maxId = df.agg(max(col("id"))).first().getLong(0)
    val maxIdD1 = df.where(col("id") === maxId).first().getString(1).toDouble


    val output = df.map( (row : Row) => {
      val id  = row.getLong(0)
      val d1  =  if(row.getString(1).isEmpty) 0.0 else row.getString(1).toDouble
      val d2  = row.getString(2)
      val r = if(d2.isEmpty) {
        d1
      } else {
        sumD2 - maxIdD1 - d2.toDouble
      }
      OutputSimpleBean(id,d1.toString, d2,r)
    }).collect().toSeq

    println(output)
  }
}

case class SimpleBean(id: Long,d1: String,d2: String)
case class OutputSimpleBean(id: Long,d1: String,d2: String,r:Double)
