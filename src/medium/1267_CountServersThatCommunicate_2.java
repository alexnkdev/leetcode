class Solution {
  public int countServers(int[][] grid) {
    int[] row = new int[grid.length];
    int[] column = new int[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          row[i]++;
          column[j]++;
        }
      }
    }
    int ret = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && (row[i] > 1 || column[j] > 1)) {
          ret++;
        }
      }
    }
    return ret;
  }
}
