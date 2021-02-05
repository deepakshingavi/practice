import org.apache.spark.sql.Row
object MapUpdater {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    //Load your data
    val df = List(
      (1,null,Map("from" ->"Will","to"-> "Watson"),null,Map("from" ->"1000","to"-> "8000"),Map("from" ->null,"to"-> "Seattle")),
      (2,null,Map("from" ->"Norman","to"-> "Nate"),null,Map("from" ->"1000","to"-> "8000"),Map("from" ->"CherryHill","to"-> "Newark")),
      (3,Map("from" ->null,"to"-> "Iowa"),Map("from" ->null,"to"-> "Ian"),Map("from" ->null,"to"-> "1004"),Map("from" ->"1000","to"-> "8000"),Map("from" ->null,"to"-> "Des Moines"))
    ).toDF("emp_id","emp_city","emp_name","emp_phone","emp_sal","emp_site")


    //Map each of your row
    df.map(row => {

      val new_emp_city = mapUpdater(row,1)
      val new_emp_name = mapUpdater(row,2)
      val new_emp_phone = mapUpdater(row,3)
      val new_emp_sal = mapUpdater(row,4)
      val new_emp_site = mapUpdater(row,5)

      (row.getInt(0),new_emp_city,new_emp_name,new_emp_phone,new_emp_sal,new_emp_site)

    }).toDF("emp_id","emp_city","emp_name","emp_phone","emp_sal","emp_site")
      .show(false)

  }

  //Row mapper function
  private def mapUpdater(row: Row,colId:Int): Map[String, String] = {
    val old_map = row.getAs[Map[String, String]](colId)

    val new_map: Map[String, String] = if (null != old_map) {
      if (null == old_map.getOrElse("from", null) && null != old_map.getOrElse("to", null)) {
        old_map + ("change" -> "Insert")
      } else if (null != old_map.getOrElse("from", null) && null == old_map.getOrElse("to", null)) {
        old_map + ("change" -> "Delete")
      } else old_map

    } else old_map
    (new_map)
  }
}
