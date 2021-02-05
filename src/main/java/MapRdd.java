import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class MapRdd {

    public static void main(String[] args) {
        JavaPairRDD<String, List<Double>> keyvals = null;
        assert keyvals != null;


        JavaPairRDD<List<String>, List<List<Double>>> result =
                keyvals.cartesian(keyvals)
                .filter(tpl -> !tpl._1._1.equals(tpl._2._1))
                        //Perform 3rd cartesian
                .cartesian(keyvals)
                        //Skip the common ids from 1st and 3rd keyvals
                .filter(tpl -> !tpl._1._1._1.equals(tpl._2._1))
                        //Map the result top Pair of Ids:List<String> and Values:List<List<Double>>
                .mapToPair((PairFunction<Tuple2<Tuple2<Tuple2<String, List<Double>>, Tuple2<String, List<Double>>>, Tuple2<String, List<Double>>>, List<String>, List<List<Double>>>) tuple2Tuple2Tuple2 -> {

                    //Combine Ids to single List
                    List<String> keys = new ArrayList<>();
                    keys.add(tuple2Tuple2Tuple2._1._1._1);
                    keys.add(tuple2Tuple2Tuple2._1._2._1);
                    keys.add(tuple2Tuple2Tuple2._2._1);

                    //Combine values to single List
                    List<List<Double>> values = new ArrayList<>();
                    values.add(tuple2Tuple2Tuple2._1._1._2);
                    values.add(tuple2Tuple2Tuple2._1._2._2);
                    values.add(tuple2Tuple2Tuple2._2._2);

                    //Return tuple of List of Ids and List of Values which are of fixed size 3
                    return new Tuple2<>(keys,values);
                });

        /*result.mapToPair(tpl -> {
            Tuple3<String, String,String> ids = new Tuple3<>(tpl._1.get(0), tpl._1.get(1), tpl._1.get(2));
            double result = calculateResult(tpl._2.get(0), tpl._2.get(1),tpl._2.get(2));
            return new Tuple2<>(ids, result);
        }).filter(tpl -> tpl._2 > threshold).saveAsTextFile("result");*/


//    });

                /*(Tuple2<Tuple2<String, List<Double>>, Tuple2<String, List<Double>>> tp1,
                         Tuple2<String, List<Double>> tp2) -> {
                            *//*Tuple3<String, String, String> keys = new Tuple3<>
                                    (tp1._1._1, tp1._2._1, tp2._1);
                            Tuple3<List<Double>, List<Double>, List<Double>> values = new Tuple3<>
                                    (tp1._1._2, tp1._2._2, tp2._2);*//*
                            return new Tuple2<>("", "");*/


    }
}
