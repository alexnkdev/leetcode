class Solution {
  public int maxNonAdjacentSum(int[] nums) {
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    if (nums.length < 1) {
      return 0;
    }
    dp[1] = nums[0];
    for (int i = 2; i <= nums.length; i++) {
      dp[i] = dp[i - 1];
      int val = nums[i - 1];
      if (i - 2 >= 0) {
        dp[i] = Math.max(dp[i], dp[i - 2] + val);
      }
    }
    int max = 0;
    for (int i = 0; i <= nums.length; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
