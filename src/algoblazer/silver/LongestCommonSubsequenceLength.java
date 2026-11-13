class Solution {
  public int longestCommonSubsequenceLength(String s, String t) {
    int n = s.length();
    int m = t.length();
    int[][] d = new int[n + 1][m + 1];
    d[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      char cs = s.charAt(i - 1);
      for (int j = 1; j <= m; j++) {
        char ct = t.charAt(j - 1);
        if (cs == ct) {
          d[i][j] = d[i - 1][j - 1] + 1;
        } else {
          d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
        }
      }
    }

    return d[n][m];
  }
}
