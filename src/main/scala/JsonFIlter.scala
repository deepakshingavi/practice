import java.io.BufferedInputStream

import org.json4s.jackson.JsonMethods.parse
import org.json4s.jackson.Serialization
import org.json4s.native.Serialization.write
import org.json4s.{DefaultFormats, Formats, ShortTypeHints}

import scala.io.Source
object JsonFIlter {
  def main(args: Array[String]): Unit = {
    implicit val formats: AnyRef with Formats = Serialization.formats(ShortTypeHints(List(classOf[PersonInfo])))
    val parseJson :List[PersonInfo] = parse("""[
                                              |  {
                                              |    "name": "John"
                                              |  },
                                              |  {
                                              |    "name": "Joseph"
                                              |  },
                                              |  {
                                              |    "name": "Peter"
                                              |  }
                                              |]""".stripMargin)
      .extract[List[PersonInfo]]
    val output = write(parseJson.filter(p => p.name.startsWith("Jo")))
    println(output)

  }

}

object JsonLoader {
  def parseJsonConfig[T: Manifest](filename: String): T = {
    implicit lazy val formats: DefaultFormats = new DefaultFormats {
      override val strictOptionParsing: Boolean = true
    }

    val inputStream = getClass.getResourceAsStream(filename)
    val lines = try {
      Source.fromInputStream(new BufferedInputStream(inputStream)).getLines.mkString
    } catch {
      case _: Exception => throw new Exception("config file not found")
    }
    parse(lines, useBigDecimalForDouble = false).extract[T]
  }
}

case class PersonInfo(name: String)
