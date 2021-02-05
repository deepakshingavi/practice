object RecursiveFactorial {

  def main(args: Array[String]): Unit = {
    val no = 100
    Util.time {
      factorial1(no)
    }
    Util.time {
      factorialN(1,no)
    }
  }

  def factorial1(n:Long) : Long = {
    if ((n == 1) || (n == 0) )
    {1}
    else {n * factorial1(n - 1)}
  }

  def factorialN(i:Long, n:Long) : Long = {
    if (i == n )
    {n}
    else {i * factorialN (i + 1,n)}
  }

}
