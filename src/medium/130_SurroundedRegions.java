
class Solution {
  public void solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    boolean[][] visited = new boolean[n][m];
    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && board[i][j] == 'O') {

          List<Cell> cells = new ArrayList<>();
          Queue<Cell> q = new LinkedList<>();
          q.add(new Cell(i, j));

          boolean hasEdgeCells = false;
          while (!q.isEmpty()) {
            Cell current = q.poll();
            visited[current.i][current.j] = true;
            cells.add(current);
            if (isEdgeCell(current, n, m)) {
              hasEdgeCells = true;
            }
            for (int k = 0; k < 4; k++) {
              int ni = current.i + di[k];
              int nj = current.j + dj[k];
              if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                if (board[ni][nj] == 'O' && !visited[ni][nj]) {
                  visited[ni][nj] = true;
                  q.add(new Cell(ni, nj));
                }
              }
            }
          }

          if (!hasEdgeCells) {
            for (Cell cell : cells) {
              board[cell.i][cell.j] = 'X';
            }
          }

        }
      }
    }
  }

  static boolean isEdgeCell(Cell cell, int n, int m) {
    return cell.i == 0 || cell.j == 0 || cell.i == n - 1 || cell.j == m - 1;
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
