class Solution {
  public String[] divideString(String s, int k, char fill) {
    int groups = s.length() / k;
    if (s.length() % k != 0) {
      groups++;
    }
    String[] ret = new String[groups];
    for (int i = 0; i < groups; i++) {
      StringBuilder str = new StringBuilder();
      for (int j = 0; j < k; j++) {
        int targetIndex = i * k + j;
        char targetCh = targetIndex < s.length() ? s.charAt(targetIndex) : fill;
        str.append(targetCh);
      }
      ret[i] = str.toString();
    }
    return ret;
  }
}
