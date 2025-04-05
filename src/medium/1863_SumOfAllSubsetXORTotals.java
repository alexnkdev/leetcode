class Solution {
  public int subsetXORSum(int[] nums) {
    int n = nums.length;
    int ret = 0;
    for (int subset = 0; subset < (1 << n); subset++) {
      int total = 0;
      for (int k = 0; k < n; k++) {
        if ((subset & (1 << k)) > 0) {
          total ^= nums[k];
        }
      }
      ret += total;
    }
    return ret;
  }
}
