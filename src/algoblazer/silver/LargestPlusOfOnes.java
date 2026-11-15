class Solution {

  int n;
  boolean[][] zero;

  public int largestPlusOrder(int n, int[][] z) {

    zero = new boolean[n][n];
    this.n = n;

    for (int i = 0; i < z.length; i++) {
      zero[z[i][0]][z[i][1]] = true;
    }
    int ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (!zero[i][j]) {
          int max = 1;
          for (int k = 1; k < n; k++) {
            
            if (isZero(i - k, j)) {
              break;
            }
            if (isZero(i + k, j)) {
              break;
            }
            if (isZero(i, j - k)) {
              break;
            }
            if (isZero(i, j + k)) {
              break;
            }
            max = k + 1;
          }
          ret = Math.max(ret, max);
        }
      }
    }
    return ret;
  }

  boolean isZero(int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= n) {
      return true;
    }
    return zero[i][j];
  }
}
