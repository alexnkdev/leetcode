class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int low = 1;
    int high = (dungeon.length + dungeon[0].length + 1) * 1000;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (hasSolution(mid, dungeon)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return high + 1;
  }

  public boolean hasSolution(int startingHP, int[][] dungeon) {
    int n = dungeon.length;
    int m = dungeon[0].length;
    int[][] maxHP = new int[n][m];
    maxHP[0][0] = startingHP + dungeon[0][0];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (maxHP[i][j] > 0) {
          if (j + 1 < m) {
            maxHP[i][j + 1] = Math.max(maxHP[i][j + 1], maxHP[i][j] + dungeon[i][j + 1]);
          }
          if (i + 1 < n) {
            maxHP[i + 1][j] = Math.max(maxHP[i + 1][j], maxHP[i][j] + dungeon[i + 1][j]);
          }
        }
      }
    }
    return maxHP[n - 1][m - 1] > 0;
  }

}
