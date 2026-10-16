class Solution {

  Integer[][] cache;
  boolean[][] ok;

  public int longestDecomposition(String text) {
    cache = new Integer[text.length() + 1][text.length() + 1];  
    ok = new boolean[text.length()][text.length()];
    for (int from = 0; from < text.length(); from++) {
      for (int len = 1; from + len <= text.length() / 2; len++) {
        String sub1 = text.substring(from, from + len);
        int to = text.length() - from;
        String sub2 = text.substring(to - len, to);
        ok[from][len] = sub1.equals(sub2);
      }
    }
    return go(text, 0, text.length());
  }

  public int go(String text, int from, int to) {
    
    if (cache[from][to] != null) {
      return cache[from][to];
    }

    if (to <= from) {
        return 0;
    }

    int ret = 1;
    int totalLength = to - from;
    
    for (int len = 1; len <= totalLength / 2; len++) {
      if (eq(text, from, from + len, to - len, to)) {
        int newFrom = from + len;
        int newTo = to - len;
        ret = Math.max(ret, go(text, newFrom, newTo) + 2);
      }    
    }

    cache[from][to] = ret;

    return ret;
  }

  boolean eq(String text, int from1, int to1, int from2, int to2) {
    int len = to1 - from1;
    return ok[from1][len];
    // TODO
    // String sub1 = text.substring(from1, to1);
    // String sub2 = text.substring(from2, to2);
    // return sub1.equals(sub2);
  }

}
