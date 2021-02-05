import org.apache.spark.sql.Dataset

object InheritDataframe {


  private def matcherDef[T <:parent](dfb: Dataset[T]): Unit = {

    dfb.toJavaRDD.classTag.toString() match {
      case "child1" =>  println("child1")
      case "child2" => println("child2")
      case _ => println("Unkown")
    }

  }

  def main(args: Array[String]): Unit = {

    val spark = Constant.getSparkSess

    import spark.implicits._

    val dfB  = List(child1(1)).toDS()
    val dfC  = List(child2(1)).toDS()

    matcherDef(dfB)
    matcherDef(dfC)

  }


}

case class child1(i: Int) extends parent(i)

case class child2(i: Int) extends parent(i)

class parent(j: Int)
