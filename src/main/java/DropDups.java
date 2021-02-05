import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.*;

public class DropDups {

    public static void main(String[] args) {
        SparkSession spark = Constant.getSparkSess();
        Dataset<Row> ds = spark.read()
                .option("header", "true")
                .csv("src/main/resources/duplicateRec.csv")
                .toDF();

        ds.show();
/* Ouputs
+--------+--------+
|Column_1|Column_2|
+--------+--------+
|       1|       A|
|       1|       X|
|       2|       X|
|       3|       B|
|       3|       X|
|       4|       C|
|       4|       D|
+--------+--------+
 */

        //Group by Column_1 and collect set of elements from Column_2 and remove 'X' from the set
        ds = ds.
                groupBy(ds.col("Column_1")).agg(
                array_remove(collect_set(ds.col("Column_2")), lit("X")).as("Column_2_list"));

        // if the set is empty then ["X"] else the actual set
        ds = ds.withColumn("Column_2_array",
                when(size(ds.col("Column_2_list")).equalTo(0), lit("X".split(",")))
                        .otherwise(ds.col("Column_2_list")));

        //Replace the column and drop the extra columns
        ds.withColumn("Column_2", explode(ds.col("Column_2_array")))
                .drop("Column_2_list", "Column_2_array")
                .show();
        /* Ouputs
+--------+--------+
|Column_1|Column_2|
+--------+--------+
|       3|       B|
|       1|       A|
|       4|       C|
|       4|       D|
|       2|       X|
+--------+--------+
         */
    }


}
