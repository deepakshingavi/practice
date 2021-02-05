import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.*;


public class CompareDfs {

    public static void main(String[] args) {
        SparkSession spark = Constant.getSparkSess();


        List<String> list1 = new ArrayList<>();
        list1.add("1,A,B,C,D,E");
        list1.add("2,X,Y,Z,P,Q");

        List<String> list2 = new ArrayList<>();
        list2.add("1,A,B6,C,D,E");
        list2.add("2,X,Y,Z8,P,Q3");

        Dataset<Row> df = spark.createDataset(list1, Encoders.STRING()).toDF().selectExpr("split(value, ',')[0] as id",
                "split(value, ',')[1] as Col_1",
                "split(value, ',')[2] as Col_2",
                "split(value, ',')[3] as Col_3",
                "split(value, ',')[4] as Col_4",
                "split(value, ',')[5] as Col_5");
//        df.printSchema();
//        df.show();
        // Convert
        Dataset<Row> df1 = spark.createDataset(list2, Encoders.STRING()).toDF().selectExpr("split(value, ',')[0] as id",
                "split(value, ',')[1] as Col_1",
                "split(value, ',')[2] as Col_2",
                "split(value, ',')[3] as Col_3",
                "split(value, ',')[4] as Col_4",
                "split(value, ',')[5] as Col_5");
//        df1.printSchema();
//        df1.show();

        //Below is the solution
        List<String> columns = Arrays.asList("Col_1", "Col_2", "Col_3", "Col_4", "Col_5"); // List of columns to merge

        // inner join the 2 dataframes
        Dataset<Row> joinedDf = df.join(df1).where(df.col("id").equalTo(df1.col("id")));



        // Iterate throgh the columns
        for (String column : columns) {
            joinedDf = joinedDf
                    .withColumn(column + "_temp",
                            when(df.col(column).equalTo(df1.col(column)), null) // When and otherwise clause for column to array/nul transformation
                                    .otherwise(split(concat_ws(",", df.col(column), df1.col(column)), ",")))
                    .drop(df.col(column)) // Drop column from 1st dataframe
                    .drop(df1.col(column)) // Drop column from 2nd dataframe
                    .withColumnRenamed(column + "_temp", column); // Rename column to the result column name
        }

//                .withColumn("Col_2_t",when(df.col("Col_2").equalTo(df1.col("Col_2")), null ).otherwise(split(concat_ws(",",df.col("Col_2"),df1.col("Col_2")),",")))


    }
}
