class Solution {
  public boolean alphanumericPalindromeCheck(String s) {
    s = s.toLowerCase();
    StringBuilder str = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
        str.append(c);
      }
    }
    String strPali = str.toString();
    for (int i = 0; i < strPali.length() / 2; i++) {
      char ch = strPali.charAt(i);
      char other = strPali.charAt(strPali.length() - i - 1);
      if (ch != other) {
        return false;
      }
    }
    return true;
  }
}
