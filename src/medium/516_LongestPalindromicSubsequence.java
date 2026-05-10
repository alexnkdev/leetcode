class Solution {

  Integer[][] cache;

  public int longestPalindromeSubseq(String s) {
    cache = new Integer[s.length() + 1][s.length() + 1];
    return gg(s, 0, s.length() - 1);
  }

  int gg(String s, int from, int to) {
    if (to < from) {
      return 0;
    }
    if (from == to) {
      return 1;
    }
    if (cache[from][to] != null) {
      return cache[from][to];
    }
    char c_left = s.charAt(from);
    char c_right = s.charAt(to);
    int ret = 0;
    if (c_left == c_right) {
      ret = Math.max(ret, 2 + gg(s, from + 1, to - 1));
    }
    ret = Math.max(ret, gg(s, from + 1, to));
    ret = Math.max(ret, gg(s, from, to - 1));
    cache[from][to] = ret;
    return ret;
  }

}
