object SimpleOuput {

  def main(args: Array[String]): Unit = {
    val result = (10 to 28).filter(i => i % 7 == 0 && i % 5 != 0 ).mkString(",")
    println(result)
  }

}
