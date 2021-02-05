import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.StructType

object DynamicCol {

  def main(args: Array[String]): Unit = {
    val spark = Constant.getSparkSess

    /// Load the JSON file
    val df = spark.read.json("src/main/resources/dyamicCol.json")

    // Temp Dataframe for fetching t he nest values
    val dfTemp = df.select(col("inputs.values").as("values"))
    val index = dfTemp.schema.fieldIndex("values")


    val propSchema = dfTemp.schema(index).dataType.asInstanceOf[StructType]

    // Join Dataframe with the list of nested columns
    propSchema.fields.foldLeft(df)((df, field) => {
      val colNameInt = (field.name.toDouble * 100).toInt
      val colName = s"v$colNameInt"

      // Add the nested column mappings
      df.withColumn(colName, col("inputs.values.`" + field.name + "`"))
    })
      .withColumn("max", col("inputs.max")) // Rename the nested column to max
      .drop("inputs") // Drop the extra nested column
      .show()
    //    dfFinal.write.mode(SaveMode.Overwrite).json("src/main/resources/dyamicColOut.json") // Output the JSON file
  }

}
