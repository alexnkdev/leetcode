class Solution {
  
  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
  
    int[][] sq = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i > 0 && j > 0) {
          sq[i][j] = (int)(matrix[i - 1][j - 1] - '0');
          sq[i][j] += sq[i][j - 1];
          sq[i][j] += sq[i - 1][j];
          sq[i][j] -= sq[i - 1][j - 1];
        }
      }
    }

    int ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int k = 1;
        while (i + k <= n && j + k <= m) {
          int square = sq[i + k][j + k] + sq[i][j] - sq[i + k][j] - sq[i][j + k];
          if (square == k * k) {
            ret = Math.max(ret, square);
          }
          k++;
        }
      }
    }
    return ret;
  }

}
