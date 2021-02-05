import org.apache.spark.SparkConf;
import org.apache.spark.internal.io.FileCommitProtocol;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.InternalRow;
import org.apache.spark.sql.execution.datasources.BasicWriteTaskStats;
import org.apache.spark.sql.execution.datasources.ExecutedWriteSummary;
import org.apache.spark.sql.execution.datasources.WriteTaskResult;

import java.util.ArrayList;
import java.util.List;

public class KryoSerializerExample {

    public static void main(String[] args) {
        Class<?>[] registerCLasses = new Class<?>[]{SampleBeanJava.class,
                InternalRow.class, InternalRow[].class,
                WriteTaskResult.class,
                FileCommitProtocol.TaskCommitMessage.class,
                ExecutedWriteSummary.class,
                BasicWriteTaskStats.class
        };
        SparkConf conf = new SparkConf()
                .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .set("spark.kryo.registrationRequired", "true")
                .registerKryoClasses(registerCLasses);

        SparkSession spark = SparkSession.builder().master("local[*]")
                .config(conf)
                .getOrCreate();

        List<SampleBeanJava> beanList = new ArrayList<>();
        beanList.add(new SampleBeanJava("A", "B"));

        final Dataset<SampleBeanJava> ds = spark.createDataset(beanList, Encoders.bean(SampleBeanJava.class));

        ds.registerTempTable("ds");
        spark.sql("select * from ds")
        .write()
                .mode("Overwrite").json("src/main/resources/kryoTest");
        ds.printSchema();
    }
}

