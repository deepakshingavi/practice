object TestTrial {

  def main(args: Array[String]): Unit = {
    val t : Int = scala.io.StdIn.readInt()
    for ( _ <-  1 to t ) {
      val number = scala.io.StdIn.readInt()
       val totSum = (1 until number).map(num => {
         number % num match {
           case 0 => num
           case _ => 0
         }
       }).sum
      if(totSum == number) {
        println("Yes")
      } else {
        println("No")
      }
    }
  }

}
