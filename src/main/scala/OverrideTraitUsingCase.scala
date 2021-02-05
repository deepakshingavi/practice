class OverrideTraitUsingCase {

}

sealed trait Book {
  def shared(contents: String)
}

case object Page extends Book {
//  def a(): UniqueToPage = println("Page")
  def shared(contents: String) = println(s"Something shared and  and $contents")
}

case object Cover extends Book {
//  def b(): UniqueToCover = println("Cover")
  def shared(contents: String) = println(s"Something shared and  and $contents")
}
