class Solution {
  static int mod = 1000000000 + 7;

  public int numTilings(int n) {
    int[][][] dp = new int[n + 1][2][2];
    int not_filled = 0;
    int filled = 1;
    dp[0][filled][filled] = 1;
    for (int i = 1; i <= n; i++) {
      for (int up = 0; up < 2; up++) {
        for (int down = 0; down < 2; down++) {
          if (up == not_filled && down == not_filled) {
            dp[i][not_filled][not_filled] = (dp[i][not_filled][not_filled] + dp[i - 1][filled][filled]) % mod;
          } else if (up == filled && down == not_filled) {
            dp[i][filled][not_filled] = (dp[i][filled][not_filled] + dp[i - 1][not_filled][not_filled]) % mod;
            dp[i][filled][not_filled] = (dp[i][filled][not_filled] + dp[i - 1][filled][not_filled]) % mod;
          } else if (up == not_filled && down == filled) {
            dp[i][not_filled][filled] = (dp[i][not_filled][filled] + dp[i - 1][not_filled][filled]) % mod;
            dp[i][not_filled][filled] = (dp[i][not_filled][filled] + dp[i - 1][not_filled][not_filled]) % mod;
          } else {
            dp[i][filled][filled] = (dp[i][filled][filled] + dp[i - 1][filled][filled]) % mod;
            dp[i][filled][filled] = (dp[i][filled][filled] + dp[i - 1][not_filled][filled]) % mod;
            dp[i][filled][filled] = (dp[i][filled][filled] + dp[i - 1][filled][not_filled]) % mod;
            dp[i][filled][filled] = (dp[i][filled][filled] + dp[i - 1][not_filled][not_filled]) % mod;
          }
        }
      }
    }
    return dp[n][1][1];
  }
}
