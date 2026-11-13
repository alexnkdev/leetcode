class Solution {
  public int longestIncreasingSubsequence(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    int ret = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = 1;
      int val = nums[i - 1];
      for (int j = 1; j < i; j++) {
        int prev = nums[j - 1];
        if (prev < val) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      ret = Math.max(ret, dp[i]);
    }
    return ret;
  }
}
