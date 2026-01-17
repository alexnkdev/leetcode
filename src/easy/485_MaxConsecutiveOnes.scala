object Solution {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    nums.foldLeft((0, 0)) {
      case ((max, streak), 0) =>
        (max, 0)
      case ((max, streak), 1) => 
        (max.max(streak + 1), streak + 1)
    }._1
  }
}
