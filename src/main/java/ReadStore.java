import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Map;
import java.util.stream.Collectors;

public class ReadStore {
    public static void main(String[] args) {
        SparkSession ss= Constant.getSparkSess();
        Dataset<Store> ds = ss.read().json("src/main/resources/store.json").as(Encoders.bean(Store.class));
        Map<String, Double> storeMap = ds.collectAsList().stream()
                .collect(Collectors.toMap(Store::getStore, Store::getProbability));
        System.out.println(storeMap);
    }
}
