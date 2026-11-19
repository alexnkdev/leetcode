class Solution {
  public int islandPerimeter(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    Square startSquare = null;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 1) {
          startSquare = new Square(i, j);
          break;
        }
      }
    }
    Queue<Square> q = new LinkedList<>();
    q.add(startSquare);

    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };

    boolean[][] visited = new boolean[n][m];

    int ret = 0;

    while (!q.isEmpty()) {
      Square current = q.poll();
      visited[current.i][current.j] = true;
      for (int k = 0; k < 4; k++) {
        int ni = current.i + di[k];
        int nj = current.j + dj[k];
        if (ni >= 0 && nj >= 0 && ni < n && nj < m && matrix[ni][nj] == 1) {
            if (!visited[ni][nj]) {
              visited[ni][nj] = true;
              q.add(new Square(ni, nj));
            }
        } else {
          if (ni < 0 || nj < 0 || ni == n || nj == m || matrix[ni][nj] == 0) {
            ret++;
          }
        }
      }
    }

    return ret;
  }

  class Square {
    int i, j;
    public Square(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
