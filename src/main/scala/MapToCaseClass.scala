import java.util
object MapToCaseClass {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess;

    import spark.implicits._

    val df  = List((12,"name","email@email.com","paygroup","level","dept_id")).toDF()
    val employeeList : util.List[EmployeeJobData] = df
      .map(row => {
        val id = if (null == row.getString(0) || "null".equals(row.getString(0)) || row.getString(0).trim.isEmpty) {
          "NULL_KEY_VALUE"
        } else {
          row.getString(0)
        }
        EmployeeJobData(id, row.getString(1), row.getString(2),
          row.getString(3), row.getString(4), row.getString(5))
      })
      .collectAsList
  }

}

case class EmployeeJobData(employee_id: String, employee_name: String,employee_email: String,paygroup: String,
                           level: String,dept_id: String)
