class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    dp[0][0] = triangle.get(0).get(0);
    for (int row = 1; row < n; row++) {
      for (int i = 0; i < row + 1; i++) {
        dp[row][i] = Integer.MAX_VALUE;
        if (i < row) {
          dp[row][i] = dp[row - 1][i] + triangle.get(row).get(i);
        }
        if (i > 0) {
          dp[row][i] = Math.min(dp[row][i], dp[row - 1][i - 1] + triangle.get(row).get(i));
        }
      }
    }
    int ret = dp[n - 1][0];
    for (int i = 0; i < n; i++) {
      ret = Math.min(ret, dp[n - 1][i]);
    }
    return ret;
  }
}
