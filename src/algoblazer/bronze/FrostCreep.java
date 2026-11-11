class Solution {
  public int frostCoverTime(int[][] w) {
    int[][] d = new int[w.length][w[0].length];
      Queue<Point> q = new LinkedList<>();
      for (int i = 0; i < w.length; i++) {
        for (int j = 0; j < w[0].length; j++) {
          if (w[i][j] == 2) {
            q.add(new Point(i, j, 0));
            d[i][j] = 0;
          }
        }
      }
  
    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };
    while (!q.isEmpty()) {
      Point current = q.poll();
      for (int k = 0; k < 4; k++) {
        int ni = current.i + di[k];
        int nj = current.j + dj[k];
        if (ni >= 0 && nj >= 0 && ni < w.length && nj < w[0].length) {
          if (w[ni][nj] == 1) {
            w[ni][nj] = 2;
            d[ni][nj] = d[current.i][current.j] + 1;
            q.add(new Point(ni, nj, current.h + 1));
          }
        }
      }
    }
    int ret = 0;
    for (int i = 0; i < w.length; i++) {
      for (int j = 0; j < w[0].length; j++) {
        if (w[i][j] == 1) {
          return -1;
        }
        if (w[i][j] == 2) {
          ret = Math.max(ret, d[i][j]);
        }
      }
    }
    return ret;

  }

  class Point {
    int i;
    int j;
    int h;
    public Point(int i, int j, int h) {
      this.i = i;
      this.j = j;
      this.h = h;
    }
  }
}
