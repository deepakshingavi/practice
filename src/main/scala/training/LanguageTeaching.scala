

import scala.collection.mutable

object LanguageTeaching {

  class LanguageStudent {

    var languages: mutable.Seq[String] = mutable.Seq()

    def getLanguages(): Iterable[String] = {
      languages
    }

    def addLanguage(language: String): Unit = {
      languages = languages :+ language
    }
  }

  class LanguageTeacher extends LanguageStudent {
    def teach(student: LanguageStudent, language: String): Boolean = {
      student.getLanguages().exists(_.equalsIgnoreCase(language))
    }

  }

  def main(args: Array[String]): Unit = {
    val teacher = new LanguageTeaching.LanguageTeacher
    teacher.addLanguage("English")
    val student = new LanguageTeaching.LanguageStudent
    //This statement was missing
    student.addLanguage("English")
    val teaches = teacher.teach(student, "English")
    println(teaches)
    for(language <- student.getLanguages())
      println(language)
  }

}

