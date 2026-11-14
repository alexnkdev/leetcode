class Solution {
  public int[] shortestPathQueries(int n, int[][] e, int[][] q) {
    Integer[][] m = new Integer[n][n];
    for (int i = 0; i < e.length; i++) {
      int a = e[i][0] - 1;
      int b = e[i][1] - 1;
      int c = e[i][2];
      if (a > b) {
        int t = a;
        a = b;
        b = t;
      }
      m[a][b] = m[a][b] == null ? c : Math.min(m[a][b], c);
      m[b][a] = m[a][b];
    }
    for (int i = 0; i < n; i++) {
      m[i][i] = 0;
    }
    Integer[][] d = new Integer[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        d[i][j] = m[i][j];
      }
    }

    for (int k = 0; k < n; k++) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
          if (d[i][k] != null && d[k][j] != null) {
            if (d[i][j] == null) {
              d[i][j] = d[i][k] + d[k][j];
            } else {
              d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
            }
          }
      }
    }
    }
    
    int[] ret = new int[q.length];
    for (int i = 0; i < q.length; i++) {
      int a = q[i][0] - 1;
      int b = q[i][1] - 1;
      ret[i] = d[a][b] != null ? d[a][b] : -1;
    }

    return ret;


  }
}
