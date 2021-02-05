import org.apache.spark.sql.functions._

object EmpManager {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._

    //Load your dataframe
    val empDF = List(Employee(1,"","","","",0.0d,"",2),
      Employee(2,"","","","",0.0d,"",-1)).toDF()

    //Create dataframe of managerIds only
    val mgrIds = empDF
      .select(col("mgr").as("empno")) // Rename mgr to empno
      //Filter those null and -1 manager IDs
      .filter($"empno".isNotNull && $"empno" =!= -1)
      //Remove duplicate Ids
      .distinct()

//    mgrIds.show()
    //empDF Inner join  mgrIds on empno column
    empDF.join(mgrIds, Seq("empno"), "inner")
      .show()


  }


}

case class Employee(empno: Int, str: String, str1: String, str2: String, str3: String, toDouble: Double, str4: String, mgr: Int)
