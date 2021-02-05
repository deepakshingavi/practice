import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SimpleRdd {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(13);
        list.add(23);
        list.add(50);

        SparkSession spark = Constant.getSparkSess();

        final JavaRDD<Integer> parallelize = new JavaSparkContext(spark.sparkContext()).parallelize(list,1);
        int max = parallelize.max(Comparator.naturalOrder());
        int min = parallelize.min(Comparator.naturalOrder());*/

        String exceptionMessage = "Duplicate entry 'Asd12345' for key 'UK_sb8bbouer5wak8vyiiy4pf2bx'";
        int firstIndex = exceptionMessage.indexOf("'")+1;
        int secondIndex = exceptionMessage.indexOf("'",firstIndex);
        System.out.println(exceptionMessage.substring(firstIndex,secondIndex));
    }

}
