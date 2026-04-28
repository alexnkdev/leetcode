class Solution {
    public boolean validDigit(int n, int x) {
      String ss = Integer.toString(n);
      int cnt = 0;
      for (int i = 0; i < ss.length(); i++) {
        char c = ss.charAt(i);
        int dig = (int)(c - '0');
        if (dig == x) {
          cnt++;
          if (i == 0) {
            return false;

          }
        }
      }
      return cnt >= 1;
    }
}
