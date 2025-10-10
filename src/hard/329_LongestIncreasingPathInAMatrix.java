class Solution {

  Integer[][] longestPath;

  public int longestIncreasingPath(int[][] matrix) {
    longestPath = new Integer[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (longestPath[i][j] == null) {
          go(i, j, matrix);
        }
      }
    }
    int ret = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        ret = Math.max(ret, longestPath[i][j]);
      }
    }
    return ret;
  }

  int go(int i, int j, int[][] matrix) {
    if (longestPath[i][j] != null) {
      return longestPath[i][j];
    }
    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };
    Integer max = null;
    for (int k = 0; k < 4; k++) {
      int ni = i + di[k];
      int nj = j + dj[k];
      if (ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length) {
        int other = matrix[ni][nj];
        if (other > matrix[i][j]) {
          int val = go(ni, nj, matrix);
          max = max == null ? val : Math.max(max, val);
        }
      }
    }
    longestPath[i][j] = max != null ? (max + 1) : 1;
    return longestPath[i][j];
  }
}
