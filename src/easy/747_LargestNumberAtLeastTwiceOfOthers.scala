object Solution {
  def dominantIndex(nums: Array[Int]): Int = {
    val max = nums.max
    val idx = nums.indexOf(max)
    if (nums.forall(x => x == max || max >= 2 * x)) idx else -1
  }
}
