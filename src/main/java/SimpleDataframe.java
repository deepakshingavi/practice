import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;
import scala.Tuple4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleDataframe {

    public static void main(String[] args) {
        SparkSession spark = Constant.getSparkSess();


        JavaRDD<Row> rdd = spark.read().option("header", "true").csv("src/main/resources/simple.csv").rdd().toJavaRDD();

        List<Tuple4<String, String, Integer, Integer>> output =
                rdd.mapToPair(   // Map input to key(String,String) and value (Collection,Num)
                (PairFunction<Row, Tuple2<String, String>, Tuple2<Set<String>, Integer>>) row -> {
                    Tuple2<String, String> tup1 = new Tuple2<>(row.getString(0), row.getString(1));
                    Set<String> set = new HashSet<>();
                    set.add(row.getString(2));
                    Tuple2<Set<String>, Integer> tup2 = new Tuple2<>(set, Integer.parseInt(row.getString(3)));
                    return new Tuple2<>(tup1, tup2);
                }
        ).reduceByKey((Function2<Tuple2<Set<String>, Integer>,   // Combine out by key to single tuple per unique tuple1
                        Tuple2<Set<String>, Integer>, Tuple2<Set<String>, Integer>>) (v1, v2) -> {
            Set<String> set = new HashSet<>();
            set.addAll(v1._1);
            set.addAll(v2._1);
            int num = v1._2 + v2._2;
            return new Tuple2<>(set, num);
        }) //// Simplest operation Mapping the combined result to required output
                        .map(tuple -> new Tuple4<>(tuple._1._1, tuple._1._2, tuple._2._1.size(), tuple._2._2))
                .collect();

        System.out.println(output);

    }
}
