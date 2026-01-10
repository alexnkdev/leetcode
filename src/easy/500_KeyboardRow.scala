object Solution {
  def findWords(words: Array[String]): Array[String] = {
    
    val keyboardRows = Array("qwertyuiop", "asdfghjkl", "zxcvbnm")

    words.filter { word => 
      val lower = word.toLowerCase
      keyboardRows.exists { row => lower.forall(row.contains) }
    }
  }
}
