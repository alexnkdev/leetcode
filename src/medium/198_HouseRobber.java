class Solution {
  public int rob(int[] nums) {
    int[][] dp = new int[nums.length][2];
    int take = 1;
    int no_take = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i - 1 >= 0) {
        dp[i][no_take] = Math.max(dp[i - 1][take], dp[i - 1][no_take]);
      } else {
        dp[i][no_take] = 0;
      }
      dp[i][take] = i - 1 >= 0 ? (dp[i - 1][no_take] + nums[i]) : nums[i];
    }
    return Math.max(dp[nums.length - 1][take], dp[nums.length - 1][no_take]);
  }
}
