import org.apache.spark.sql.{Row, SparkSession}

object Main12 extends Serializable {

  class Input_Class extends Serializable {
    var name: String = "";
    var age: String = "";
    var gender: String = "";

    def setter(src: Row) {
      var row = src.toSeq
      var i = 0;
      name = (row(i)).toString;
      i += 1;
      age = (row(i)).toString;
      i += 1;
      gender = (row(i)).toString;
    }

    def printing(row: Row, spark: SparkSession) {
      println(name, age, gender)
    }
  }

  class Output_Class extends Serializable {
    var name: String = "";
    var age: Int = 0;
    var gender: String = "";
    var marks: Int = 0;

    def writer(spark: SparkSession){
      val data = Array(name,age,gender,marks)
      val distData = spark.sparkContext.parallelize(data)
      distData.collect().foreach(println)
    }
  }

  class Manager extends Serializable {
    var inputObj = new Input_Class();
    var outputObj = new Output_Class();

    def inputSetter(src: Row) = {
      inputObj.setter(src);
    }

    def transformation(spark: SparkSession){
      outputObj.age = inputObj.age.toInt;
      outputObj.name = inputObj.name;
      outputObj.gender = inputObj.gender;
      outputObj.marks = 100;
      outputwriter(spark);
    }

    def outputwriter(spark: SparkSession){
      outputObj.writer(spark);
    }
  }

  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("App").config("spark.master", "local").getOrCreate()
    val df = spark.read.csv("data.csv");
    var ManagerObj = new Manager();
    df.rdd.map(row => {
      ManagerObj.inputSetter(row)
      ManagerObj.transformation(spark);
    }).collect();
    spark.stop()
  }
}