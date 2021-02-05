import org.apache.spark.SparkContext
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import scala.collection.mutable.ListBuffer

object CompileProg {

  def main(args: Array[String]): Unit = {
    val log = org.apache.log4j.LogManager.getLogger("Spark log")
//    log.setLevel(Level.INFO)
//    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark: SparkSession = SparkSession.builder().appName("generationobj").master("local[*]").config("spark.sql.crossJoin.enabled", value = true).getOrCreate()
    val sc: SparkContext = spark.sparkContext
    import spark.implicits._

    val atomData: DataFrame = spark.read.option("header", "true")
      .option("inferschema", "true")
      .csv(args(0))

    val moleculeData: DataFrame = spark.read.option("header", "true")
      .option("inferschema", "true")
      .csv(args(1))


    val df = moleculeData.join(atomData,"molecule_id")

    val molecule_df = moleculeData

    val featureCol = df.columns
    var indexers: Array[StringIndexer] = Array()
    for (colName <- featureCol) {
      val index = new StringIndexer()
        .setInputCol(colName)
        .setOutputCol(colName + "_indexed")
      //.fit(trainDF)
      indexers = indexers :+ index
    }
    val pipeline = new Pipeline()
      .setStages(indexers)
    var newDF = pipeline.fit(df).transform(df)

    val mid: List[Row] = molecule_df.select("molecule_id").collect.toList
    var listofmoleculeid: List[String] = mid.map(r => r.getString(0))
    // print(listofmoleculeid)
    newDF.createTempView("table")

    for(i<-0 to listofmoleculeid.length - 1) {

      val id = listofmoleculeid(i)
      //  print("testing new code")

      val values = newDF.filter(newDF("molecule_id") === listofmoleculeid(i)).select("element_indexed", "type_indexed", "charge_indexed")

      //values.show(4)

      val element: List[Row] = values.select("element_indexed").collect.toList
      var listofelementCol: List[Double] = element.map(r => r.getDouble(0))

      val typevalue: List[Row] = values.select("type_indexed").collect.toList
      var listoftypeCol: List[Double] = typevalue.map(r => r.getDouble(0))

      val charge: List[Row] = values.select("charge_indexed").collect.toList
      var listofchargeCol: List[Double] = charge.map(r => r.getDouble(0))

      // print(listofchargeCol)

      val ListofValues = ListBuffer[Double]()

      /*ListofValues += covarianceofcol(listofelementCol, listofelementCol)
      ListofValues += covarianceofcol(listofelementCol, listoftypeCol)
      ListofValues += covarianceofcol(listofelementCol, listofchargeCol)
      ListofValues += covarianceofcol(listoftypeCol, listofelementCol)
      ListofValues += covarianceofcol(listoftypeCol, listoftypeCol)
      ListofValues += covarianceofcol(listoftypeCol, listofchargeCol)
      ListofValues += covarianceofcol(listofchargeCol, listofelementCol)
      ListofValues += covarianceofcol(listofchargeCol, listoftypeCol)
      ListofValues += covarianceofcol(listofchargeCol, listofchargeCol)*/


      import org.apache.spark.sql.functions._

      if(listofmoleculeid(i)=="d1") {

        val numsDf =
          Seq(ListofValues)
            .toDF("nums")
            .select(ListofValues.indices.map(i => col("nums")(i).alias(s"newCol$i")): _*)

        newDF = newDF.join(numsDf, newDF.col("molecule_id") === lit(listofmoleculeid(i)), "outer")

      }
      else {
        val numsDf = Seq(ListofValues)
        newDF =newDF.withColumn("newCol0",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(0)).otherwise(col("newCol0"))).
          withColumn("newCol1",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(1)).otherwise(col("newCol1"))).
          withColumn("newCol2",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(2)).otherwise(col("newCol2"))).
          withColumn("newCol3",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(3)).otherwise(col("newCol3"))).
          withColumn("newCol4",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(4)).otherwise(col("newCol4"))).
          withColumn("newCol5",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(5)).otherwise(col("newCol5"))).
          withColumn("newCol6",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(6)).otherwise(col("newCol6"))).
          withColumn("newCol7",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(7)).otherwise(col("newCol7"))).
          withColumn("newCol8",when(col("molecule_id") === listofmoleculeid(i),split(lit(numsDf.mkString(",")),",")(8)).otherwise(col("newCol8")))

        newDF.show(1000)
      }

    }

  }

}
