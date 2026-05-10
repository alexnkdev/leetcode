class Solution {

  static long MOD = 1000000007L;

    static Map<String, List<String>> cache = new HashMap<>();

  public int numDecodings(String s) {

    int n = s.length();
    long[] d = new long[n + 1];
    d[0] = 1;

    for (int i = 1; i <= n; i++) {
      char ch = s.charAt(i - 1);

      long total = 0;

      for (int k = 1; k <= 2; k++) {
        if (i - k >= 0) {
          String pattern = s.substring(i - k, i);

          List<String> subs = gen_all(0, pattern);
          for (String sub : subs) {
            if (is_ok(sub)) {
              total = (total + d[i - k]) % MOD;
            }
          }
        }
      }


      d[i] = total;
    }

    return (int) d[n];
  }

  boolean is_ok(String sub) {
    if (sub.length() == 1) {
      Integer xx = Integer.parseInt(sub);
      return xx >= 1 && xx <= 9;
    } else {
      Integer xx = Integer.parseInt(sub);
      return xx >= 10 && xx <= 26;
    }

  }

  List<String> gen_all(int k, String pattern) {
    if (k == 0 && cache.containsKey(pattern)) {
        return cache.get(pattern);
    }
    if (k == pattern.length()) {
      List<String> ret = new ArrayList<>();
      ret.add("");
      return ret;
    }
    char ch = pattern.charAt(k);
    List<String> ret = new ArrayList<>();
    if (ch == '*') {
      List<String> sub = gen_all(k + 1, pattern);
      for (int kk = 1; kk <= 9; kk++) {
        for (String s : sub) {
          ret.add(Integer.toString(kk) + s);
        }
      }
    } else {
      List<String> sub = gen_all(k + 1, pattern);
      for (String s : sub) {
        ret.add("" + ch + s);
      }
    }
    if (k == 0) {
        cache.put(pattern, ret);
    }
    return ret;
  }

}
