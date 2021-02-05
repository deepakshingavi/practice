import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

class MyData implements Serializable {

    private Map<String, List<String>> myMap;

    MyData(SparkSession sparkSession, String inputPath) {
    }
}