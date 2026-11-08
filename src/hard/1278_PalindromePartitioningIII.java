class Solution {
  public int palindromePartition(String s, int k) {
    int n = s.length();
    int[][] cost = new int[n][n + 1];
    
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {

        cost[i][j] = 0;
        int len = j - i;
        for (int cc = 0; cc < len / 2; cc++) {
          char c1 = s.charAt(i + cc);
          char c2 = s.charAt(j - cc - 1);
          if (c1 != c2) {
            cost[i][j]++;
          }
        }
      }
    }
    
    Integer[][] dp = new Integer[n + 1][k + 1];
    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int kk = 1; kk <= k; kk++) {

        for (int pali_from = 0; pali_from < i; pali_from++) {

          if (dp[pali_from][kk - 1] == null) {
            continue;
          }
          
          dp[i][kk] = dp[i][kk] == null ? dp[pali_from][kk - 1]
            + cost[pali_from][i]
            : Math.min(dp[i][kk], dp[pali_from][kk - 1] + cost[pali_from][i]);

        }

      }
    }

    return dp[n][k];
  }
}
