object Grouping {

  def main(args: Array[String]): Unit = {
    val data = List((List("c1"),"Y"), (List("c1"),"N"), (List("c1"),"N"), (List("c1"),"Y"), (List("c1"),"Y"))

    val result = data.groupBy(grp => (grp._1,grp._2))
      .mapValues(count =>  BigDecimal(count.size.toDouble).setScale(3)./(BigDecimal(data.size.toDouble).setScale(3))
        .setScale(3, BigDecimal.RoundingMode.HALF_UP))
        .map( k => (k._1._1,k._1._2,k._2)).toList
    println("result=="+result)

  }

}
