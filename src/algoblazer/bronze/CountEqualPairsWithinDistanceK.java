class Solution {
  public int countEqualPairsWithin(int[] nums, int k) {
    int ret = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j] && (j - i <= k)) {
          ret++;
        }
      }
    }
    return ret;
  }
}
