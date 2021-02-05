import org.apache.spark.sql.functions._

object WhenThen {

  def main(args: Array[String]): Unit = {


    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters = args.takeRight(args.length - 4)
    println(filters)

    val spark = Constant.getSparkSess

    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)


    import spark.implicits._
    val df = List(("apple", "fruit", "apple1", "apple2"),
      ("beans", "vege", "beans1", "beans2"),
      ("beef", "meat", "beef1", "beans2"),
      ("kiwi", "fruit", "kiwi1", "beef2"),
      ("pork", "meat", "pork1", "pork2")
    ).toDF("name", "type", "item1", "item2")

    df.withColumn("prop",
      when($"type" === "fruit", $"item1").otherwise(
        when($"type" === "vege", $"item1").otherwise(
          when($"type" === "meat", $"item2").otherwise("")
        )
      )).show()

  }

}
