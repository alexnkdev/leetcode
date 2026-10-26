class Solution {

  boolean[][] visited;
  int[] di = new int[] { 0, 0, 1, -1 };
  int[] dj = new int[] { 1, -1, 0, 0 };

  public int closedIsland(int[][] grid) {
    
    int ret = 0;
    visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0 && !visited[i][j]) {
          boolean closed = isClosed(grid, i, j);
          if (closed) {
            ret++;
          }
        }
      }
    }

    return ret;
  }

  boolean isEdge(int[][] grid, int i, int j) {
    return i < 0 || j < 0 || i == grid.length || j == grid[0].length;
  }

  boolean isClosed(int[][] grid, int i, int j) {
    visited[i][j] = true;

    boolean ret = true;

    for (int k = 0; k < 4; k++) {
      int ni = i + di[k];
      int nj = j + dj[k];
      if (isEdge(grid, ni, nj)) {
        ret = false;
      }
      if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && !visited[ni][nj]) {
        if (grid[ni][nj] == 0) {
          ret &= isClosed(grid, ni, nj);
        }
      }
    }

    return ret;
  }

}
