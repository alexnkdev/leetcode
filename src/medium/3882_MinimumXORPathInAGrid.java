class Solution {
  public int minCost(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int MAX = 1024;
    boolean [][][] reachable = new boolean[n][m][MAX];

    reachable[0][0][grid[0][0]] = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int dd = 0; dd < MAX; dd++) {
          if (reachable[i][j][dd]) {
            
            if (i + 1 < n) {
              int xr = dd ^ grid[i + 1][j];
              reachable[i + 1][j][xr] = true;
            }

            if (j + 1 < m) {
              int xr = dd ^ grid[i][j + 1];
              reachable[i][j + 1][xr] = true;
            }

          }
        }
      }
    }

    int ret = MAX;
    for (int dd = 0; dd < MAX; dd++) {
      if (reachable[n - 1][m - 1][dd]) {
        ret = Math.min(ret, dd);
      }
    }

    return ret;

  }
}
