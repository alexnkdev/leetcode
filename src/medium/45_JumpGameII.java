class Solution {
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    boolean[] visited = new boolean[nums.length];
    dp[0] = 0;
    visited[0] = true;
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        continue;
      }
      for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
        if (!visited[j]) {
          visited[j] = true;
          dp[j] = dp[i] + 1;
        } else {
          dp[j] = Math.min(dp[j], dp[i] + 1);
        }
      }
    }
    return dp[nums.length - 1];
  }
}
