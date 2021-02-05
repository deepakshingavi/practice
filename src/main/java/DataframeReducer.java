import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;

public class DataframeReducer {
    public static void main(String[] args) {
        Dataset<Row> ds1= null; // populate your DataSet1
        Dataset<Row> ds2= null; // populate your DataSet1
        ds1.union(ds2);
    }
}
