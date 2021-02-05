object SerDer {
  def main(args: Array[String]): Unit = {
    ObjectSerialization.serialize()
    ObjectDeserialization.deSerialize()
  }
}

import java.io._

object AnObject extends Serializable {
  var x = 2.0
  var s = "Here's a string"

} // AnObject object


object ObjectSerialization extends App {
  def serialize() {
    AnObject.s = "This is an updated string 2"
    val oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/AnObject.ser"))
    oos.writeObject(AnObject)
    oos.close()
  }
} // ObjectDeserialization object

object ObjectDeserialization extends App {
  def deSerialize() {
    val ois = new ObjectInputStream(new FileInputStream("src/main/resources/AnObject.ser"))
    val obj = ois.readObject.asInstanceOf[AnObject.type]
    ois.close()
    println(obj.s)
  }
}
