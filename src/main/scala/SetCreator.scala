import scala.collection.JavaConversions

object SetCreator {

  val StringSet : scala.collection.Set[String] = Set("abc","xyz")

  JavaConversions.seqAsJavaList(StringSet.toSeq)

}
