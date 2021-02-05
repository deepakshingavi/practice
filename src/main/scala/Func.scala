

object Func {

  var floats: List[Float] = List.empty

  var list: List[List[Option[String]]] = List.empty

  def main(args: Array[String]): Unit = {
    val output : Map[Float, (String, String)]= storeHashmap(list,floats)
  }

  def storeHashmap(
                    keys: List[List[Option[String]]],
                    similarities: List[Float]
                  ): Map[Float, (String, String)] = {
    val yieldOutput = for ((k, s) <- keys.zip(similarities))
      yield s -> (k.head.get, k.last.get)
    yieldOutput.toMap
  }

}
