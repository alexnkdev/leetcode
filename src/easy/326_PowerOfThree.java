class Solution {
  public boolean isPowerOfThree(int n) {
    if (n < 0) {
      return false;
    }
    if (n == 1) {
      return true;
    }
    String s = Integer.toString(n, 3);
    if (s.length() <= 1 || s.charAt(0) != '1') {
      return false;
    }
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != '0') {
        return false;
      }
    }
    return true;
  }
}
