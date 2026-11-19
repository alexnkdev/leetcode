class Solution {
  
  Long[][] cache;

  public long firstPlayerScore(int[] v) {
    long[] p = new long[v.length + 1];
    p[0] = 0;
    for (int i = 1; i <= v.length; i++) {
      p[i] = p[i - 1] + v[i - 1];
    }
    cache = new Long[v.length][v.length + 1];
    return rec(0, v.length, v, p);
  }

  long rec(int i, int j, int[] v, long[] p) {
    if (cache[i][j] != null) {
        return cache[i][j];
    }
    int len = j - i;
    if (len == 1) {
      return v[i];
    } else {
      
      long val1 = v[i] + (p[j] - p[i + 1] - rec(i + 1, j, v, p));
      long val2 = v[j - 1] + (p[j - 1] - p[i] - rec(i, j - 1, v, p));

      long ret = Math.max(val1, val2);
      cache[i][j] = ret;

      return ret;
    }
  }

}
