object Solution {
  def commonChars(words: Array[String]): List[String] = {
    words(0).filter(ch => words.forall(_.contains(ch))).map(_.toString).toList
  }
}
