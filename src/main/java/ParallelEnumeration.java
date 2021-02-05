import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParallelEnumeration {
    public static void main(String[] args) {
        String zipFilePath = "/ZipDir/";
        File zipFiles = new File(zipFilePath);
        final List<File> files = Arrays.asList(Objects.requireNonNull(zipFiles.listFiles()));
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Print Elements of RDD")
                .setMaster("local[*]");
        // start a spark context
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        // parallelize the file collection to two partitions
        jsc.parallelize(files, 2)
                .filter(file -> { // This filter is optional if the directory contains only zip files
                    // https://stackoverflow.com/questions/33934178/how-to-identify-a-zip-file-in-java
                    DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
                    int test = in.readInt();
                    in.close();
                    return test == 0x504b0304;
                }).foreach((VoidFunction<File>) file -> System.out.println(file.getName()));

    }
}
