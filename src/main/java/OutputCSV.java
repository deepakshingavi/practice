import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.expressions.Encode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputCSV {

    public static void main(String[] args) {

        SparkSession spark = Constant.getSparkSess();

        List<String> list = new ArrayList<>();

        ((ArrayList<String>)list).clone();


        list.add("");
        final Dataset<String> dataset = spark.createDataset(list, Encoders.STRING());

        dataset.toDF()
                .coalesce(1)
                .limit(0)
                .write().format("csv")
                .option("delimiter","|")
                .option("inferSchema", "true")
                .option("header","true")
                .option("nullValue","null")
                .mode(SaveMode.Overwrite)
                .save("src/main/resource/string.csv");


    }
}
