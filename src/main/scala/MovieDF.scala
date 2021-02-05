import org.apache.spark.sql.Encoders

object MovieDF {

  def main(args: Array[String]): Unit = {
    val src = "src/main/resources/movie.csv"
    val spark = Constant.getSparkSess
    import spark.implicits._
    val time1 = time {
      val moviesDS1 = spark.sparkContext.textFile(src)
        .map(x => Movie1(x.split("\t")(1).toInt))
        .toDS
        .select("movieID").show()
    }
    val time2 = time {
      val movieSchema = Encoders.product[Movie].schema

      val moviesDS2 = spark.read.options(Map("delimiter" -> "\t"))
        .schema(movieSchema)
        .csv(src)
        .select("movieID").show()
    }

    println(time1/time2)


  }

  def time[R](block: => R): Long = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    (t1 - t0)
  }

}

final case class Movie(movieID: Int, Somenum1: Int, Somenum2: Int, Somenum3: Int)

final case class Movie1(movieID: Int)
