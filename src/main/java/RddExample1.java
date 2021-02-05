import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.plans.RightOuter;
import scala.Tuple2;
import scala.collection.Seq;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RddExample1 {

    private static final Pattern SPACE = Pattern.compile(" ");
    public static void main(String[] args) {


        SparkSession spark = Constant.getSparkSess();
        String input = "5 4 6 20 2\n" +
                "5 1 30 4 10\n" +
                "3 5 7 40 20";
        processRdd(input,spark);

        String input1 = "5 4 6 20 2\n" +
                "5 1 30 4 10\n" +
                "3 5 7 40 20\n" +
                "3 2 1 5 90";
        processRdd(input1,spark);

//        result.saveAsTextFile("PATH");

        Dataset dataset2 = spark.emptyDataFrame();
        Dataset dataset1 = spark.emptyDataFrame();
        Dataset<Row> dataset3 = dataset1.as("dataset1").join(dataset2.as("dataset2"),
                dataset1.col("target_guid").equalTo(dataset2.col("target_guid")), RightOuter.sql());
    }

    static void processRdd(String input, SparkSession spark){
        final JavaSparkContext javaSparkContext = new JavaSparkContext(spark.sparkContext());
        JavaRDD<String> lines = javaSparkContext.parallelize(Arrays.asList( input.split("\n")));

        JavaRDD<String[]> words = lines.map(s -> (SPACE.split(s))).filter(x->x.length==5);


        JavaPairRDD<Integer, Integer[]> tupla = words.mapToPair(x -> new Tuple2<>(Integer.parseInt(x[0]),new Integer[] {Integer.parseInt(x[1]),Integer.parseInt(x[2]),Integer.parseInt(x[3]),1}));

        JavaPairRDD<Integer, Integer[]> test = tupla.reduceByKey((x,y)-> new Integer[] {Math.min(x[0],y[0]) ,(x[2]+y[2])/(x[3]+y[3])});

        JavaRDD<String> result = test.map(couple -> String.valueOf(couple._1())+":"+String.valueOf(couple._2()[0])+","+String.valueOf(couple._2()[1]));

        result.collect();

        result.foreach(r -> {
            System.out.println(r.toString());
        });
    }
}
