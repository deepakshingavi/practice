object Example1 {

  import java.io.FileNotFoundException

  import scala.io.BufferedSource
  import scala.io.Source.fromFile

    def main(args: Array[String]): Unit = {
      val fileName: String = if(args.length == 1) args(0) else ""
      try {
        val file = fromFile(fileName)

        /* In file tekst.txt is 4 lines */
        println(s"In file $fileName is ${countLines(file)} lines")
        /* In file tekst.txt is 0 lines */
        println(s"In file $fileName is ${countLines(file)} lines")

        file.close
      }
      catch{
        case e: FileNotFoundException => println(s"File $fileName not found")
        case _: Throwable => println("Other error")
      }
    }

    def countLines(file: BufferedSource): Long = {
      file.getLines.count(_ => true)
    }

}
