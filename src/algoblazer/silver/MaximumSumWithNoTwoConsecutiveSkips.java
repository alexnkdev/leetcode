class Solution {
  public long maxSumNoTwoConsecutiveSkips(int[] nums) {
    long[][] dp = new long[nums.length + 1][2];
    
    int can_skip = 0;
    int no_skip = 1;
    dp[1][0] = nums[0];
    dp[1][1] = nums[0];
    for (int i = 2; i <= nums.length; i++) {
      long val = nums[i - 1];
      dp[i][can_skip] = Math.max(dp[i - 1][can_skip] + val, dp[i - 1][no_skip] + val);
      if (i > 1) {
        dp[i][can_skip] = Math.max(dp[i][can_skip], dp[i - 2][no_skip] + val);
      }

      dp[i][no_skip] = Math.max(dp[i - 1][can_skip] + val, dp[i - 1][no_skip] + val);
    }


    long ret = Math.max(dp[nums.length][can_skip], dp[nums.length][no_skip]);
    if (nums.length > 1) {
      ret = Math.max(ret, dp[nums.length - 1][no_skip]);
    }
    return ret;
  }
}
