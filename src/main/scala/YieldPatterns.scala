object YieldPatterns {

  def main(args: Array[String]): Unit = {
    val pat1 ="""(?sm)^\s*#.+?$"""
    val pat2 ="""(?sm)^(.+?((['"])[^\\3]*\3))(.*)"""
    val pat3 ="""(?sm)(#.+?$)"""
    val file_list = List("aaaa","1111","222")

    val output : List[String] = file_list.map(fileName => {
      var ans = fileName
      if(ans.matches(pat1)) {
        ans = pat1.r.replaceAllIn(ans,"")
      }
      if(ans.matches(pat2)) {
        ans = pat2.r.replaceAllIn(ans,m => {
          "".concat(m.group(1))
        })
      }
      if(ans.matches(pat3)) {
        ans = pat3.r.replaceAllIn(ans,"")
      }
      ans
    })
    println(output)
  }

}
