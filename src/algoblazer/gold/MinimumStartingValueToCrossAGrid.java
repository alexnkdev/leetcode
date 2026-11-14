class Solution {
  public int minStartingValue(int[][] grid) {

    int low = 1;
    int high = grid.length * grid[0].length * 2000;

    int mid = -1;
    while (low < high) {
      mid = low + (high - low) / 2;
      boolean ok = check(grid, mid);
      if (ok) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  boolean check(int[][] grid, int startingValue) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] d = new int[n][m];
    d[0][0] = grid[0][0] + startingValue;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        d[i][j] = -1;
        if (i > 0 && d[i - 1][j] >= 1) {
          d[i][j] = Math.max(d[i][j], d[i - 1][j] + grid[i][j]);
        }
        if (j > 0 && d[i][j - 1] >= 1) {
          d[i][j] = Math.max(d[i][j], d[i][j - 1] + grid[i][j]);
        }
      }
    }

    if (d[n - 1][m - 1] <= 0) {
      return false;
    }

    return true;

  }

}
