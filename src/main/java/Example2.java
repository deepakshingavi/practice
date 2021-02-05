import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import scala.Option;

import java.util.Arrays;

public class Example2 {

    /*public void testDatasetWithOptionField(){
        SparkSession spark = SparkSession.builder().master("local[*]").getOrCreate()
        Dataset<TestClass> ds = spark.createDataset(Arrays.asList(
                new TestClass("item 1", Option.apply(1)),
                new TestClass("item .", Option.empty())
        ), Encoders.bean(TestClass.class));

        ds.collectAsList().forEach(x -> System.out.println("Found " + x));
    }*/
}



 class TestClass {
    String id;
    Option<Integer> optionalInt;
}
