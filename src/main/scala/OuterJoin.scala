import org.apache.spark.sql.Column
import org.apache.spark.sql.catalyst.expressions.{BRound, Literal, Round}
import org.apache.spark.sql.functions.{withExpr, _}

object OuterJoin {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val cols = Array("rowid", "name", "status", "lastupdated")

    val df1 = List(
      ("1-za23f0", "product1", "active", "30-12-2019"),
      ("1-za23f1", "product2", "inactive", "31-12-2019"),
      ("1-za23f2", "product3", "inactive", "01-01-2020"),
      ("1-za23f3", "product4", "inactive", "02-01-2020"),
      ("1-za23f4", "product5", "inactive", "03-01-2020"))
      .toDF(cols:_ *)
      .withColumn("source",lit("rdd1"))

    val df2 = List(
      ("1-za23f0", "product1", "active", "30-12-2019"),
      ("1-za23f1", "product2", "active", "31-12-2019"),
      ("1-za23f2", "product3", "active", "01-01-2020"),
      ("1-za23f3", "product1", "inactive", "02-01-2020"),
      ("1-za23f4", "product5", "inactive", "03-01-2020"))
      .toDF(cols:_ *)
        .withColumn("source",lit("rdd2"))

    df1.union(df2)
      .groupBy(cols.map(col):_ *)
      .agg(collect_set("source").as("sources"))
      .filter(size(col("sources")) === 1)
      .withColumn("from_rdd", explode(col("sources") ))
      .drop("sources")
      .show()

    /*df1.join(df2, usingColumns = cols.toSeq,"outer")
      .orderBy(col("rowid"),col("name"))
//      .where(df1.col("source").isNull || df2.col("source").isNull)
      .show()*/
    df1.join(df2, usingColumns = cols.toSeq,"left")
      //      .where(df1.col("source").isNull || df2.col("source").isNull)
      .show()
  }

  /**
    Rounding mode to round towards {@literal "nearest neighbor"}
    unless both neighbors are equidistant, in which case round up.
    Behaves as for {@code RoundingMode.UP} if the discarded
    fraction is &ge; 0.5; otherwise, behaves as for
    {@code RoundingMode.DOWN}.  Note that this is the rounding
    mode commonly taught at school.
   *
   * <p>Example:
    input=5.5 output=6
    input=2.5 output=3
    input=1.6 output=2
    input=1.1 output=1
    input=1.0 output=1
    input=-1.0 output=-1
    input=-1.1 output=-1
    input=-1.6 output=-2
    input=-2.5 output=-3
    input=-5.5 output=-6
   */


  /**
    Rounding mode to round towards the {@literal "nearest neighbor"}
    unless both neighbors are equidistant, in which case, round
    towards the even neighbor.  Behaves as for
    {@code RoundingMode.HALF_UP} if the digit to the left of the
    discarded fraction is odd; behaves as for
    {@code RoundingMode.HALF_DOWN} if it's even.  Note that this
    is the rounding mode that statistically minimizes cumulative
    error when applied repeatedly over a sequence of calculations.
    It is sometimes known as {@literal "Banker's rounding,"} and is
    chiefly used in the USA.  This rounding mode is analogous to
    the rounding policy used for {@code float} and {@code double}
    arithmetic in Java.


    input=5.5 output=6
    input=2.5 output=2
    input=1.6 output=2
    input=1.1 output=1
    input=1.0 output=1
    input=-1.0 output=-1
    input=-1.1 output=-1
    input=-1.6 output=-2
    input=-2.5 output=-2
    input=-5.5 output=-6
   */
  

}
