class Solution {
  public int editDistance(String a, String b) {
    int n = a.length();
    int m = b.length();
    int[][] d = new int[n + 1][m + 1];
    d[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      d[i][0] = i;
    }
    for (int j = 1; j <= m; j++) {
      d[0][j] = j;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        char ca = a.charAt(i - 1);
        char cb = b.charAt(j - 1);
        d[i][j] = d[i][j - 1] + 1;
        d[i][j] = Math.min(d[i][j], d[i - 1][j] + 1);
        if (ca == cb) {
          d[i][j] = Math.min(d[i][j], d[i - 1][j - 1]);
        } else {
          d[i][j] = Math.min(d[i][j], d[i - 1][j - 1] + 1);
        }
      }
    }
    return d[n][m];
  }
}
