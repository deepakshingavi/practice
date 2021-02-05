import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, DataFrame}

object AggAllColumns {

  def main(args: Array[String]): Unit = {
    val df: DataFrame = null

    //Map all column except _c1 and _c0 to expression
    val aggColumns: Array[Column] = df.columns
      .filter(colName => !"_c0".equals(colName) && !"_c1".equals(colName))
      .map(colName => collect_list(colName))
    df.
      groupBy("_c0")
      //This is needed to avoid method overloaded compile error
      .agg(collect_list("_c1"),
        //Expand the mapped list
        aggColumns: _*)
      .show()
  }

}
