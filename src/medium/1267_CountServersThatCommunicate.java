class Solution {
  public int countServers(int[][] grid) {
    int[][] comms_row = new int[grid.length][grid[0].length];
    int[][] comms_column = new int[grid.length][grid[0].length];
    for (int row = 0; row < grid.length; row++) {
      int cnt_row = 0;
      for (int column = 0; column < grid[0].length; column++) {
        if (grid[row][column] == 1) {
          cnt_row++;
        }
      }
      for (int column = 0; column < grid[0].length; column++) {
        if (grid[row][column] == 1) {
          comms_row[row][column] = cnt_row;
        }
      }
    }

    for (int column = 0; column < grid[0].length; column++) {
      int cnt_column = 0;
      for (int row = 0; row < grid.length; row++) {
        if (grid[row][column] == 1) {
          cnt_column++;
        }
      }
      for (int row = 0; row < grid.length; row++) {
        if (grid[row][column] == 1) {
          comms_column[row][column] = cnt_column;
        }
      }
    }

    int ret = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (comms_row[i][j] > 1 || comms_column[i][j] > 1) {
          ret++;
        }
      }
    }

    return ret;
  }
}
