import java.nio.file.{Path, Paths}

object GetParentFolderName {

  def main(args: Array[String]): Unit = {
    //Create Path from the input string
    val path : Path = Paths.get("file:/C:/workspace/Spark_Scala_Exercise2/src/main/Resources/exercise-2/input/run_1/batch_id=73/part-00000-7489f493-c825-469a-9877-0b0e2c75cd4b.c000.snappy.parquet")

    //Get Parent folder name
    println(path.getParent.getFileName)
  }

}
