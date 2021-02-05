

object AnyCaseClass {

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess
    import spark.implicits._

    val df  = List(AnyCaseClassBean(1),AnyCaseClassBean(2) ).toDF()

    df.show()

  }

}

case class  AnyCaseClassBean(value: Int)
