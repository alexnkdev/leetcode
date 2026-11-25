class Solution {
  public int minBlockedCellsToCross(int[][] grid) {

    int n = grid.length;
    int m = grid[0].length;

    Long[][] d = new Long[n][m];

    PriorityQueue<Square> q = new PriorityQueue<>((sq1, sq2) -> {
      return Long.compare(sq1.dist, sq2.dist);
    });

    d[0][0] = 0L;
    Square startSquare = new Square(0, 0, 0L);
    q.add(startSquare);

    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };

    int blocked_weight = 1000000;

    boolean[][] visited = new boolean[n][m];

    while (!q.isEmpty()) {
      Square current = q.poll();
      if (visited[current.i][current.j]) {
        continue;
      }
      visited[current.i][current.j] = true;

      for (int k = 0; k < 4; k++) {
        int ni = current.i + di[k];
        int nj = current.j + dj[k];
        if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
          int w;
          if (grid[ni][nj] == 0) {
            w = 1;
          } else {
            w = blocked_weight;
          }
          if (!visited[ni][nj] && (d[ni][nj] == null || d[ni][nj] > d[current.i][current.j] + w)) {
            d[ni][nj] = d[current.i][current.j] + w;
            q.add(new Square(ni, nj, d[current.i][current.j] + w));
          }
        }
      }
    }

    int ret = 0;
    while (d[n - 1][m - 1] - blocked_weight >= 0) {
      ret++;
      d[n - 1][m - 1] -= blocked_weight;
    }

    return ret;

  }

  class Square {
    int i, j;
    long dist;
    public Square(int i, int j, long dist) {
      this.i = i;
      this.j = j;
      this.dist = dist;
    }
  }
}
