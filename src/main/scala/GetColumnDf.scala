import java.sql.Date

object GetColumnDf {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    val map = Map("Emp_ID" -> "Dimension","Cust_Name" -> "Dimension","Cust_Age" -> "Measure",
      "Salary" -> "Measure","DoJ" -> "Dimension")

    import spark.implicits._
    val lsit = Seq(Bean123("C-1001","Jack",25,3000,new Date(2000000))).toDF().schema.fields
      .map( col => (col.name,col.dataType.toString,map.get(col.name))).toList.toDF("Headers","Data_Type","Type")
    lsit.show()
  }

}

case class Bean123(Emp_ID: String,Cust_Name: String,Cust_Age: Int, Salary : Int,DoJ: Date)
