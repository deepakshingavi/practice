import org.apache.spark.sql.Encoders
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StructField, StructType}

object DefaultFieldValue {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._
    val jsonDataIncomplete: String = """{"a": "foo"}"""
    val dsIncomplete = spark.read.json(Seq(jsonDataIncomplete).toDS)
    val schema: StructType = Encoders.product[SchemaClass].schema

    val fields: Array[StructField] = schema.fields

    val outdf = fields.diff(dsIncomplete.columns).foldLeft(dsIncomplete)((acc, col) => {
      acc.withColumn(col.name, lit(null).cast(col.dataType))
    })

    outdf.printSchema()
    outdf.show()


  }
}

case class SchemaClass(a: String, b: Int, c: String, d: Double)


