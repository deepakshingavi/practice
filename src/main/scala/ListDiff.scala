object ListDiff {
  def main(args: Array[String]): Unit = {
    val list = List(List("Eat", "Drink", "Sleep", "work"), List("Eat", "Sleep", "Dance"));
    val diff = list.head.diff(list(1))
    println(diff)
  }

}
