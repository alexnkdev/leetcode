class Solution {
  public int numDistinct(String s, String t) {
    int n = s.length();
    int m = t.length();
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 1;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int ans = 0;
        if (i > 0) {
          ans += dp[i - 1][j];
        }
        if (i > 0 && j > 0 && s.charAt(i - 1) == t.charAt(j - 1)) {
          ans += dp[i - 1][j - 1];
        }
        dp[i][j] = ans;
      }
    }
    return dp[n][m];
  }
}
