object Solution {
  def minOperations(logs: Array[String]): Int = {
    logs.foldLeft(0) {
      case (depth, "../") => math.max(0, depth - 1)
      case (depth, "./") => depth
      case (depth, _) => depth + 1
    }
  }
}
