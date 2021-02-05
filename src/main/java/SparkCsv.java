import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.MapGroupsFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DoubleType;
import org.apache.spark.sql.types.StringType;
import org.apache.spark.sql.types.StructType;

public class SparkCsv {
    public static void main(String[] args) {
        SparkSession spark = Constant.getSparkSess();
        Encoder<String> stringEncoder = Encoders.STRING();

        /*spark.read().csv("src/main/resources/test.csv")
                .map((MapFunction<Row, String>) Row::mkString, stringEncoder)
                .groupByKey((MapFunction<String, String>) s -> "", stringEncoder)
                .mapGroups((MapGroupsFunction<String, String,String>)(key, values) -> {
                    Iterable<String> vals = () -> values;
                    return String.join("|", vals);
                }, stringEncoder)
                .repartition(1) // if you want to have single file
                .write()
                .csv("src/main/resources/out1");*/


        StructType schema = new StructType()
                .add("col3", "string", false)
        .add("col2", "string", false);
        Dataset<Row> ds = spark.read().option("header","true").schema(schema).csv("src/main/resources/test.csv");
        ds.show();


    }

}
