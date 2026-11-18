class Solution {
  public boolean canSplitIntoThreePalindromes(String s) {
    int n = s.length();
    int k = 3;

    boolean[][] dp = new boolean[n + 1][k + 1];
    dp[0][0] = true;

    boolean[][] isPali = new boolean[n + 1][n + 1];

    for (int i = 0; i < n; i++) {
      isPali[i][1] = true;
      isPali[i][0] = true;
    }

    for (int len = 2; len <= n; len++) {
      for (int from = 0; from < n && from + len <= n; from++) {
        char first = s.charAt(from);
        char last = s.charAt(from + len - 1);
        if (first == last) {
          isPali[from][len] = isPali[from + 1][len - 2];
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int kk = 1; kk <= k; kk++) {

        for (int j = 0; j < i; j++) {


          int len = i - j;

          if (isPali[j][len]) {
            dp[i][kk] |= dp[j][kk - 1];
          }

        }
      }
    }

    return dp[n][k];

  }
}
