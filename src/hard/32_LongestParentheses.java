class Solution {
  public int longestValidParentheses(String s) {
    int ret = 0;
    for (int i = 0; i < s.length(); i++) {
      int max = 0;
      int balance = 0;
      for (int j = i; j < s.length(); j++) {
        char c = s.charAt(j);
        if (c == '(') {
          balance++;
        } else {
          balance--;
        }
        if (balance < 0) {
          break;
        }
        if (balance == 0) {
          max = Math.max(max, j - i + 1);
        }
      }
      ret = Math.max(ret, max);
    }
    return ret;
  }
}
