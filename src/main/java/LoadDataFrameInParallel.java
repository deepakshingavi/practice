import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class LoadDataFrameInParallel {

    public static void main(String[] args) throws InterruptedException {
        List<String> filPaths = new ArrayList<>();
        SparkSession spark = Constant.getSparkSess();
        List<LoadDataFrame> futureList =  filPaths.stream().map( filePath -> new LoadDataFrame(spark,filePath)).collect(Collectors.toList());
        ExecutorService executor = Executors.newFixedThreadPool(filPaths.size());
        List<Future<Dataset<String>>> output =  executor.invokeAll(futureList);
        output.forEach(future -> {
            try {
                future.get().count();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}


class LoadDataFrame implements Callable<Dataset<String>> {

    private final SparkSession spark;
    private final String filePath;

    public LoadDataFrame(SparkSession spark, String filePath) {
        this.spark = spark;
        this.filePath = filePath;
    }

    @Override
    public Dataset<String> call() {
        return spark.read().textFile(filePath).cache();
    }
}
