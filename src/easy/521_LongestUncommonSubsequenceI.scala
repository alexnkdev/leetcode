object Solution {
  def findLUSLength(a: String, b: String): Int =
    (a, b) match {
      case (x, y) if x == y => -1
      case _ => math.max(a.length, b.length)
    }
}
