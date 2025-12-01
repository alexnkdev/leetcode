class Solution {
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] partialSums = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m ; j++) {
        int val = matrix[i - 1][j - 1] == '1' ? 1 : 0;
        int sum = val;
        sum += partialSums[i - 1][j];
        sum += partialSums[i][j - 1];
        sum -= partialSums[i - 1][j - 1];
        partialSums[i][j] = sum;
      }
    }
    int max = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        for (int k = i; k <= n; k++) {
          for (int t = j; t <= m; t++) {
            int sum = partialSums[k][t] - partialSums[i][t] - partialSums[k][j] + partialSums[i][j];
            int s = (k - i) * (t - j);
            if (sum == s) {
                max = Math.max(max, sum);
            }
          }
        }
      }
    }
    return max;
  }
}
