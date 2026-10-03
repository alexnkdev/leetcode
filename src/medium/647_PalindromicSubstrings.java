class Solution {
  
  Boolean[][] cache;


  public int countSubstrings(String s) {
    
    int n = s.length();

    int cnt = 0;

    cache = new Boolean[n][n];

    for (int i = 0 ; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (isPali(i, j, s)) {
          cnt++;
        }
      }
    }

    return cnt;
  }

  boolean isPali(int i, int j, String s) {
    
    if (j <= i) {
      return true;
    }

    if (cache[i][j] != null) {
      return cache[i][j];
    }

    char first = s.charAt(i);
    char last = s.charAt(j);

    if (first != last) {
      return false;
    }

    boolean sub = isPali(i + 1, j - 1, s);

    
    cache[i][j] = sub;

    return sub;


  }


}
