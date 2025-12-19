object Solution {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    return nums1.filter(x => nums2.contains(x)).distinct;
  }
}
