class Solution {
  public int[][] matrixMultiply(int[][] a, int [][] b) {

    if (a[0].length != b.length) {
      return new int[][] { };
    }

    int[][] ret = new int[a.length][b[0].length];

    for (int i = 0; i < ret.length; i++) {
      for (int j = 0; j < ret[0].length; j++) {
        for (int k = 0; k < a[0].length; k++) {
          ret[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return ret;
  }
}
