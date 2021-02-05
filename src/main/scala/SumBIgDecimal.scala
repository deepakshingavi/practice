import org.apache.spark.sql.functions._

object SumBIgDecimal {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val df = List(ExpenseEntry("John", "candy", 0.5),
      ExpenseEntry("Tia", "game", 0.25),
      ExpenseEntry("John", "candy", 0.15),
      ExpenseEntry("Tia", "candy", 0.55)).toDF

    df.groupBy("category", "name").agg(  sum(bround( col("amount"),2) ).as("sum_amount")).show()
  }

}

case class ExpenseEntry(
                         name: String,
                         category: String,
                         amount: BigDecimal
                       )
