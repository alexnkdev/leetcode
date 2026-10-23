class Solution {

  Boolean[][] cache;

  public int minCut(String s) {
  

    int[] d = new int[s.length() + 1];

    int n = s.length();
    cache = new Boolean[n + 1][n + 1];

    d[0] = 0;

    for (int i = 1; i <= n; i++) {
      d[i] = d[i - 1] + 1;
      for (int k = 0; k <= i; k++) {
        int from = k;
        int to = i;
        if (isPali(s, from, to)) {
          d[i] = Math.min(d[i], d[k] + 1);
        }
      }
    }

    return d[n] - 1;

  }

  boolean isPali(String s, int from, int to) {
    if (to == from + 1) {
      return true;
    }
    if (to == from) {
      return true;
    }
    if (cache[from][to] != null) {
      return cache[from][to];
    }
    char start = s.charAt(from);
    char end = s.charAt(to - 1);
    boolean ret = false;
    if (start == end) {
      ret = isPali(s, from + 1, to - 1);
    }
    cache[from][to] = ret;
    return ret;
  }

}
