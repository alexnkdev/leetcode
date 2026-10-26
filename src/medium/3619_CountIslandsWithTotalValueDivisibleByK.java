class Solution {
  
  boolean[][] visited;
  int[] di = new int[] { 0, 0, 1, -1 };
  int[] dj = new int[] { 1, -1, 0, 0 };

  public int countIslands(int[][] grid, int k) {
    int n = grid.length;
    int m = grid[0].length;
    visited = new boolean[n][m];
    int ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] != 0 && !visited[i][j]) {
          long islandSize = calcSize(grid, i, j);
          if (islandSize % k == 0) {
            ret++;
          }
        }
      }
    }
    return ret;
  }

  long calcSize(int[][] grid, int i, int j) {

    long ret = grid[i][j];
    visited[i][j] = true;
    for (int k = 0; k < 4; k++) {
      int ni = i + di[k];
      int nj = j + dj[k];
      if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] != 0 && !visited[ni][nj]) {
        visited[ni][nj] = true;
        ret += calcSize(grid,  ni, nj);
      }
    }
    return ret;

  }

}
