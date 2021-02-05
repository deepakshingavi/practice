import scala.util.Try

object WeightedAverage {
  def mean(input1: Array[Int], input2: Array[Int]): Try[Double] = {
    Try {
      if (input1.length != input2.length) {
        throw new RuntimeException("Both array size not same!!!")
      }
      (input1, input2).zipped.map((x, y) => x * y).sum / input2.sum
    }
  }
  def main(args: Array[String]): Unit = {
    println(mean(Array(3,6),Array(4,2)))
    println(mean(Array(3,6),Array(0,0)))
    println(mean(Array(3,6),Array(0)))
  }
}
