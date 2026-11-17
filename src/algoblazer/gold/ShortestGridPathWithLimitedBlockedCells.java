class Solution {
  public int shortestPath(int[][] grid, int k) {
    int n = grid.length;
    int m = grid[0].length;
    Integer[][][] d = new Integer[n][m][k + 1];

    d[0][0][0] = 0;
    Queue<State> q = new LinkedList<>();
    q.add(new State(0, 0, 0));

    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };

    while (!q.isEmpty()) {
      State current = q.poll();
      
      for (int kk = 0; kk < 4; kk++) {
        int ni = current.i + di[kk];
        int nj = current.j + dj[kk];
        if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
          int nk;
          if (grid[ni][nj] == 1) {
            nk = current.k + 1;
          } else {
            nk = current.k;
          }
          if (nk <= k && d[ni][nj][nk] == null) {
            d[ni][nj][nk] = d[current.i][current.j][current.k] + 1;
            q.add(new State(ni, nj, nk));
          }
        }
      }
    }

    Integer ret = null;
    for (int kk = 0; kk <= k; kk++) {
      if (d[n - 1][m - 1][kk] == null) {
        continue;
      }
      ret = ret == null ? d[n - 1][m - 1][kk] 
        : Math.min(ret, d[n - 1][m - 1][kk]);
    }
    return ret == null ? -1 : ret;
  }

  class State {
    int i, j, k;
    public State(int i, int j, int k) {
      this.i = i;
      this.j = j;
      this.k = k;
    }
  }
}
