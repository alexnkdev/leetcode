class Solution {
  
  public int colorTheGrid(int m, int n) {
    
    int MAX = 1;
    for (int i = 0; i < m; i++) {
        MAX *= 3;
    }
    long MOD = 1000000000 + 7;
    
    long[][] dp = new long[MAX][n];
    for (int i = 0; i < MAX; i++) {
      dp[i][0] = isCorrectTiling(i, m) ? 1 : 0;
    }
    

    for (int row = 1; row < n; row++) {
      for (int currentSet = 0; currentSet < MAX; currentSet++) {
        if (!isCorrectTiling(currentSet, m)) {
            continue;
        }
        for (int prevSet = 0; prevSet < MAX; prevSet++) {
          if (isCorrectTiling(prevSet, m) && match(currentSet, prevSet, m)) {
            dp[currentSet][row] = (dp[currentSet][row] + dp[prevSet][row - 1]) % MOD;
          }
        }
      }
    }

    long ret = 0;
    for (int i = 0; i < MAX; i++) {
      ret = (ret + dp[i][n - 1]) % MOD;
    }

    return (int) ret;

  }

  int[] decode(int set, int m) {
    int[] ret = new int[m];
    int idx = 0;
    while (set != 0) {
      int rem = set % 3;
      ret[idx++] = rem;
      set /= 3;
    }
    return ret;
  }

  boolean isCorrectTiling(int set, int m) {
    int[] currentRow = decode(set, m);
    for (int i = 1; i < currentRow.length; i++) {
      if (currentRow[i] == currentRow[i - 1]) {
        return false;
      }
    }
    return true;
  }

  boolean match(int currentSet, int prevSet, int m) {
    int[] currentRow = decode(currentSet, m);
    int[] prevRow = decode(prevSet, m);
    for (int i = 1; i < currentRow.length; i++) {
      if (currentRow[i] == currentRow[i - 1]) {
        return false;
      }
    }
    for (int i = 1; i < prevRow.length; i++) {
      if (prevRow[i] == prevRow[i - 1]) {
        return false;
      }
    }

    for (int i = 0; i < prevRow.length; i++) {
      if (prevRow[i] == currentRow[i]) {
        return false;
      }
    }
    
    return true;
  }

}
