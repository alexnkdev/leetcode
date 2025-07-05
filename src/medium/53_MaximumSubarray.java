class Solution {
  public int maxSubArray(int[] nums) {
    int currentSum = 0;
    Integer ret = null;
    for (int i = 0; i < nums.length; i++) {
      ret = ret == null ? nums[i] : Math.max(ret, nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      ret = Math.max(ret, currentSum);
      if (currentSum < 0) {
        currentSum = 0;
      }
    }
    return ret;
  }
}
