class Solution {
  public int totalXorOverAllSubsets(int[] nums) {
    int n = nums.length;
    int ret = 0;
    for (int set = 0; set < (1 << n); set++) {
      int xor = 0;
      for (int j = 0; j < n; j++) {
        if ((set & (1 << j)) > 0) {
          xor ^= nums[j];
        }
      }
      ret += xor;
    }
    return ret;
  }
}
