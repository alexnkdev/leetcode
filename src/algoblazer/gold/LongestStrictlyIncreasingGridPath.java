class Solution {

  int[] di = new int[] { 0, 0, 1, -1 };
  int[] dj = new int[] { 1, -1, 0, 0, };

  Integer[][] max;

  public int longestIncreasingGridPath(int[][] grid) {
    max = new Integer[grid.length][grid[0].length];

    int ret = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        ret = Math.max(ret, go(i, j, grid));
      }
    }

    return ret;
  }

  int go(int i, int j, int[][] grid) {
    if (max[i][j] != null) {
      return max[i][j];
    }
    max[i][j] = 1;
    for (int k = 0; k < 4; k++) {
      int ni = i + di[k];
      int nj = j + dj[k];
      if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length) {
        int val = grid[i][j];
        int other = grid[ni][nj];
        if (other > val) {
          max[i][j] = Math.max(max[i][j], go(ni, nj, grid) + 1);
        }
      }
    }
    return max[i][j];
  }

}
