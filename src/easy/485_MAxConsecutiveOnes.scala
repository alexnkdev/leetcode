object Solution {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    nums.foldLeft((0, 0)) {
      case ((current, max), 1) =>
        (current + 1, max.max(current + 1))
      case ((_, max), _) =>
        (0, max)
    }._2
  }
}
