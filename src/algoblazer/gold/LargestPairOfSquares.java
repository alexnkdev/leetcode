class Solution {
  public int largestPairOfSquares(int[][] g) {
    int low = 0;
    int high = g.length;
    while (low < high) {
      int mid = low + (high - low + 1) / 2;
      if (possible(g, mid)) {
        low = mid;
      } else {
        high = mid - 1;
      }
    }
    return low;
  } 

  boolean possible(int[][] g, int squareSide) {
    
    int n = g.length;
    int m = g[0].length;

    int[][] p = new int[n][m + 1];
    for (int i = 0; i < n; i++) {
      p[i][0] = 0;
      for (int j = 1; j <= m; j++) {
        p[i][j] = p[i][j - 1] + g[i][j - 1];
      }
    }

    List<Square> squares = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i + squareSide <= n && j + squareSide <= m) {
          boolean good = true;
          for (int row = i; row < i + squareSide; row++) {
            int rowVal = p[i][j + squareSide] - p[i][j];
            if (rowVal != squareSide) {
              good = false;
              break;
            }
          }
          if (good) {
            squares.add(new Square(i, j));
          }
        }
      }
    }


    return false;
  }

  boolean isOverlap(Square sq1, Square sq2, int side) {
    int minI = Math.min(sq1.i, sq2.i);
    int maxI = Math.max(sq1.i, sq2.i);

    int minJ = Math.min(sq1.j, sq2.j);
    int maxJ = Math.max(sq1.j, sq2.j);

    if (maxI >= minI + side) {
      return false;
    }
    if (maxJ >= minJ + side) {
      return false;
    }
    return true;
  }

  class Square {
    int i;
    int j;
    public Square(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public String toString() {
      return "[" + i + ", " + j + "]";
    }
  }
  
}
