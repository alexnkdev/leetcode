class Solution {

  public int[] pathsWithMaxScore(List<String> board) {
    int MOD = 1000000000 + 7;
    int n = board.size();
    int m = board.get(0).length();

    int[] di = new int[] { -1, 0, -1 };
    int[] dj = new int[] { 0, -1, -1 };

    Integer[][] max = new Integer[n][m];
    int[][] paths = new int[n][m];
    max[n - 1][m - 1] = 0;
    paths[n - 1][m - 1] = 1;

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (max[i][j] == null) {
          continue;
        }
        for (int k = 0; k < di.length; k++) {
          int ni = i + di[k];
          int nj = j + dj[k];
          if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
            if (board.get(ni).charAt(nj) != 'X') {
              int nval = 0;
              if (board.get(ni).charAt(nj) != 'E') {
                nval = (int)(board.get(ni).charAt(nj) - '0');
              }
              if (max[ni][nj] == null) {
                max[ni][nj] = max[i][j] + nval;
                paths[ni][nj] = paths[i][j];
              } else {
                if (max[ni][nj] < max[i][j] + nval) {
                    max[ni][nj] = max[i][j] + nval;
                    paths[ni][nj] = paths[i][j];
                } else if (max[ni][nj] == max[i][j] + nval) {
                    paths[ni][nj] = (paths[ni][nj] + paths[i][j]) % MOD;
                }
                
              }
            } 
          }
          
        }

      }
    }

    if (max[0][0] == null) {
      return new int[] { 0, 0 };
    }


    return new int[] { max[0][0], paths[0][0] };
  }

}
