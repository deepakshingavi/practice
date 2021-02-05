import org.apache.spark.sql.SparkSession;

public class Constant {

    public static SparkSession getSparkSess(){
        return SparkSession.builder().master("local[*]").getOrCreate();
    }


}
