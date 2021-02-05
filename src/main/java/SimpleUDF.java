import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF0;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataTypes;

import java.util.List;

public class SimpleUDF {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder().master("local[*]").getOrCreate();
        spark.sqlContext()
                .udf()
                .register("sampleUDFLambda", (List<String> array) -> array.stream().filter(element ->
                        !element.isEmpty()).findFirst().orElse(null), DataTypes.StringType);

    }

    //Or you can define a function

    private UDF1< List<String>,String> sampleUdf()
    {
        return ( array ) -> array.stream().filter(element ->
                !element.isEmpty()).findFirst().orElse(null);
    }




}
