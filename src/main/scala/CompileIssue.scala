object CompileIssue {

  def main(args: Array[String]): Unit = {
    def id = 1l
    def name = ""
  }

}

case class User(id: Long, name: String)

/*
class UserTable(tag: Tag) extends Table[User](tag, "user") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")

}*/
