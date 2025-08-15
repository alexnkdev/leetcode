class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int n = s1.length();
    int m = s2.length();
    int t = s3.length();
    boolean[][][] dp = new boolean[t + 1][n + 1][m + 1];
    dp[0][0][0] = true;
    for (int tt = 1; tt <= t; tt++) {
      for (int nn = 0; nn <= n; nn++) {
        for (int mm = 0; mm <= m; mm++) {
          char ct = s3.charAt(tt - 1);
          if (nn > 0 && s1.charAt(nn - 1) == ct) {
            dp[tt][nn][mm] |= dp[tt - 1][nn - 1][mm];
          }
          if (mm > 0 && s2.charAt(mm - 1) == ct) {
            dp[tt][nn][mm] |= dp[tt - 1][nn][mm - 1];
          }
        }

      }
    }
    return dp[t][n][m];
  }
}
