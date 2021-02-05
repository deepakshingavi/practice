import org.apache.spark.api.java.function.VoidFunction2;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.Trigger;

public class ReadSocketJ {

    public static void main(String[] args) throws StreamingQueryException {
        SparkSession spark = Constant.getSparkSess();


        Dataset<Row> lines = spark
                .readStream()
                .format("socket")
                .option("host", "127.0.0.1") // Replace it your socket host
                .option("port", "9090")
                .load();

        lines.writeStream()
                .trigger(Trigger.ProcessingTime("5 seconds"))
                .foreachBatch((VoidFunction2<Dataset<Row>, Long>) (v1, v2) -> {
                    v1.as(Encoders.STRING())
                            .collectAsList().forEach(System.out::println);
                }).start().awaitTermination();


    }
}
