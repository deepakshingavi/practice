import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.ReduceFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelizeArray {

    public static void main1(String[] args) {
        final SparkSession sparkSess = Constant.getSparkSess();
        List<String> codesList = Arrays.asList("code1", "code2");
        final Dataset<String> dataFrame = sparkSess.createDataset(codesList, Encoders.STRING());
        dataFrame.write().mode(SaveMode.Append).csv("src/main/resources/paraArray");
    }

    public static void main(String[] args) {
        List<String> codesList = Arrays.asList("code1","code2");
        SparkConf sparkConf = new SparkConf().setAppName("Print Elements of RDD")
                .setMaster("local[*]");
        // start a spark context
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        final SparkSession sparkSess = SparkSession.builder().master("local[*]").getOrCreate();
        Dataset<String> codes = sparkSess.createDataset(codesList , Encoders.bean(String.class));
        String filePath= "";

        List<Row> list=new ArrayList<>();
        list.add(RowFactory.create("one"));
        list.add(RowFactory.create("two"));
        list.add(RowFactory.create("three"));
        list.add(RowFactory.create("four"));

        List<org.apache.spark.sql.types.StructField> listOfStructField=new ArrayList<org.apache.spark.sql.types.StructField>();
        listOfStructField.add(DataTypes.createStructField("test", DataTypes.StringType, true));
        StructType structType=DataTypes.createStructType(listOfStructField);
        Dataset<Row> ds= sparkSess.createDataFrame(list,structType);
        ds.show();

        final Encoder<Dataset> bean = Encoders.bean(Dataset.class);
        Dataset<Row> ds_res = codes.map((MapFunction<String, Dataset>) x_cod -> calcFunction(sparkSess, filePath, ds ,x_cod),bean)
                .reduce((ReduceFunction<Dataset>) (df1, df2) -> df1.union(df2));

    }

    public static Dataset<Row> calcFunction(SparkSession sparkSession, String filePath, Dataset<Row> ds ,String x_cod ){
        Dataset<Row> ds_res = null;//some complex calculation based on x_cod
        return ds_res ; // return ds_res  for further processing
    }
}
