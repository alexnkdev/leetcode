class Solution {
  
  public double knightProbability(int n, int k, int row, int column) {
    

    double[][][] prob = new double[n][n][k + 1];

    prob[row][column] = 1.0;


   int[] drow = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
   int[] dcol = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };

    for (int step = 0; step < k; step++) {
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          
          for (int d = 0; d < 8; d++) {
            int nr = r + drow[d];
            int nc = c + dcol[d];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
              prob[nr][nc][step + 1] += prob[r][c][step] / 8.0;
            }
          }

        }
      }
    }


    double ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ret += prob[i][j][k];
      }
    }


    return ret;

  }

}
