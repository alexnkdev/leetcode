object Solution {

  val morse: Array[String] = Array(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");

  def uniqueMorseRepresentations(words: Array[String]): Int = {
    words.map(w => toMorse(w)).toSet.size
  }

  def toMorse(w: String): String = {
    w.flatMap(ch => morse(ch - 'a'))
  }

}
