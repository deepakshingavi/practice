import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

public class ParallelSparkWrite {

    public static void main(String[] args) {
        SparkSession spark = Constant.getSparkSess();

        Dataset<Row> ds = spark.read().json("input/path");

        List<String> filterValue = new ArrayList<>();

        //Create a parallel stream
        filterValue.parallelStream()
                .forEach(filter -> {
                    //Filter your DataSet and write in parallel
            ds.filter(ds.col("col1").equalTo(filter)).write().json("/output/path/"+filter+".json");
        });


    }
}
