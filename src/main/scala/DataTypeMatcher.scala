

object DataTypeMatcher {

  def main(args: Array[String]): Unit = {
    val obj: Int = 5;
    /*var objType: Class[_] = obj.getClass
    val byeBuffer = ByteBuffer.allocate(10)
    obj match {
      case _: Int   =>
        byeBuffer.putInt(asInstanceOf[Int])

      case _: Long =>
        byeBuffer.putLong(asInstanceOf[Long])

      case _: Float =>
        byeBuffer.putFloat(asInstanceOf[Float])

      case _: Double =>
        byeBuffer.putDouble(asInstanceOf[Double])

      case default => {
        Try(asInstanceOf[Boolean]).orElse({
          throw new UnsupportedOperationException("Type not supported: " + default.getClass)
        })
      }
    }*/
  }

}
