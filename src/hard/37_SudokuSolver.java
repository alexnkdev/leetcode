class Solution {
  public void solveSudoku(char[][] board) {
    rec(board);
  }

  boolean rec(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    List<Point> empty = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '.') {
          empty.add(new Point(i, j));
        }
      }
    }
    if (empty.size() == 0) {
      return true;
    }
    Map<Point, List<Integer>> pointToCandidates = new HashMap<>();
    for (Point p : empty) {
      for (int candidate = 1; candidate <= 9; candidate++) {
        if (isCanPutCandidateAtPoint(p, candidate, board)) {
          if (pointToCandidates.get(p) == null) {
            pointToCandidates.put(p, new ArrayList<>());
          }
          pointToCandidates.get(p).add(candidate);
        }
      }
    }
    Point smallestPoint = null;
    Integer smallestLength = 0;
    for (Point p : pointToCandidates.keySet()) {
      if (smallestPoint == null || smallestLength > pointToCandidates.get(p).size()) {
        smallestPoint = p;
        smallestLength = pointToCandidates.get(p).size();
      }
    }
    if (smallestPoint == null) {
      return false;
    }
    for (Integer candidate : pointToCandidates.get(smallestPoint)) {
      board[smallestPoint.i][smallestPoint.j] = (char) ('0' + candidate);
      boolean subProblem = rec(board);
      if (subProblem) {
        return true;
      }
      board[smallestPoint.i][smallestPoint.j] = '.';
    }
    return false;
  }

  boolean isCanPutCandidateAtPoint(Point p, int candidate, char[][] board) {
    char chValue = (char) ('0' + candidate);
    for (int i = 0; i < board.length; i++) {
      if (board[i][p.j] == chValue) {
        return false;
      }
    }
    for (int j = 0; j < board[0].length; j++) {
      if (board[p.i][j] == chValue) {
        return false;
      }
    }
    int square_i = (p.i / 3) * 3;
    int square_j = (p.j / 3) * 3;
    for (int i = square_i; i < square_i + 3; i++) {
      for (int j = square_j; j < square_j + 3; j++) {
        if (board[i][j] == chValue) {
          return false;
        }
      }
    }
    return true;
  }

  static class Point {
    int i;
    int j;

    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public String toString() {
      return "P(" + i + "," + j + ")";
    }
  }
}
