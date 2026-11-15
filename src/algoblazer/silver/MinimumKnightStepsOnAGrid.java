class Solution {
  public int minKnightSteps(int n, int r1, int c1, int r2, int c2) {
    Integer[][] d = new Integer[n][n];
    d[r1][c1] = 0;
    
    int[] dr = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
    int[] dc = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };

    Queue<Square> q = new LinkedList<>();
    q.add(new Square(r1, c1));

    while (!q.isEmpty()) {
      Square cur = q.poll();
      for (int k = 0; k < 8; k++) {
        int nr = cur.r + dr[k];
        int nc = cur.c + dc[k];
        if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
          if (d[nr][nc] == null) {
            d[nr][nc] = d[cur.r][cur.c] + 1;
            q.add(new Square(nr, nc));
          }
        }
      }
    }


    return d[r2][c2] == null ? -1 : d[r2][c2];
  }

  class Square {
    int r, c;
    public Square(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
