class Solution {
  public int countBattleships(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    boolean[][] visited = new boolean[n][m];
    int ships = 0;
    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && board[i][j] == 'X') {
          ships++;
          Queue<Cell> q = new LinkedList<>();
          q.add(new Cell(i, j));
          while (!q.isEmpty()) {
            Cell current = q.poll();
            visited[current.i][current.j] = true;
            for (int k = 0; k < 4; k++) {
              int ni = current.i + di[k];
              int nj = current.j + dj[k];
              if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                if (!visited[ni][nj] && board[ni][nj] == 'X') {
                  visited[ni][nj] = true;
                  q.add(new Cell(ni, nj));
                }
              }
            }
          }
        }
      }
    }
    return ships;
  }

  static class Cell {
    int i;
    int j;

    public Cell(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
