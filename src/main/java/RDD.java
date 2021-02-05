import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.concurrent.ExecutionException;

public class RDD {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        JavaSparkContext sc = new JavaSparkContext();
        JavaRDD<String> lines = sc.textFile("data.txt");
        JavaRDD<String> processedLines = lines
                .map(line -> {
                    // processed here
                    return "";
                });
        processedLines.foreachAsync(line -> {
            // Send to server
        }).get();

        processedLines.foreachPartitionAsync(lineIterator -> {
            while (lineIterator.hasNext()) {
                String line = lineIterator.next();
            }
        }).get();
    }
}
