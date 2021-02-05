import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

public class JavaRdd {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        SparkSession spark = Constant.getSparkSess();
        final JavaRDD<String> parallelize = new JavaSparkContext(spark.sparkContext()).parallelize(list,1);
        List<String> dd = parallelize.collect();
        System.out.println(dd);
        parallelize.saveAsTextFile("src/main/resources/javaList");
        /*dataset.foreachPartition( dataSetBatch -> {
            DefaultHttpClient http = new DefaultHttpClient();
            if(dataSetBatch.hasNext()) {
                dataSetBatch.next();
                // invoke submit hhtp request here
            }
            http.close();

        });*/
    }
}
