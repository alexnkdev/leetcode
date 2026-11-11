class Solution {
  public int countEqualPairs(int[] nums) {
    int n = nums.length;
    int ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] == nums[j]) {
          ret++;
        }
      }
    }
    return ret;
  }
}
