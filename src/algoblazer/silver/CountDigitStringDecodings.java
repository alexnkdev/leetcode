class Solution {
  public int countDecodings(String s) {
    int n = s.length();
    int[] d = new int[n + 1];
    d[0] = 1;
    
    for (int i = 1; i <= n; i++) {
      d[i] = 0;
      for (int j = 0; j < i; j++) {
        if (i - j > 4) {
          continue;
        }
        String sub = s.substring(j, i);
          if (isValid(sub)) {
            d[i] += d[j];
          }
      }
    }
    return d[n];
  }

  boolean isValid(String sub) {
    if (sub.startsWith("0")) {
      return false;
    }
    Long x = Long.parseLong(sub);
    return x >= 1 && x <= 26;
  }
}
