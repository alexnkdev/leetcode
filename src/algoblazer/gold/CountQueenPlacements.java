class Solution {
  
  boolean[][] queen;
  boolean[] used_ver;
  boolean[] diag_primary;
  boolean[] diag_secondary;

  public int countQueenPlacements(int n) {
    queen = new boolean[n][n];
    used_ver = new boolean[n];
    diag_primary = new boolean[2 * n];
    diag_secondary = new boolean[2 * n];
    return count(0, n);
  }

  int count(int hor, int n) {
    if (hor == n) {
      return 1;
    } else {
      int ret = 0;
      for (int i = 0; i < n; i++) {
        if (!used_ver[i]) {
          int dp = i - hor + n;
          int ds = i + hor;
          if (diag_primary[dp] || diag_secondary[ds]) {
            continue;
          } 
  
          diag_primary[dp] = true;
          diag_secondary[ds] = true;
          queen[hor][i] = true;
          used_ver[i] = true;

          ret += count(hor + 1, n);
          
          queen[hor][i] = false;
          used_ver[i] = false;
          diag_primary[dp] = false;
          diag_secondary[ds] = false;
        }
      }
      return ret;
    }
  }
}
