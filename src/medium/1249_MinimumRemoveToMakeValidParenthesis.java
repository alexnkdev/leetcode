class Solution {
  public String minRemoveToMakeValid(String s) {
    int balance = 0;
    boolean[] remove = new boolean[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        balance++;
      } else if (s.charAt(i) == ')') {
        balance--;
      }
      if (balance < 0) {
        remove[i] = true;
        balance++;
      }
    }

    if (balance > 0) {
      for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '(') {
          remove[i] = true;
          balance--;
          if (balance == 0) {
            break;
          }
        }
      }
    }

    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (!remove[i]) {
        ret.append(s.charAt(i));
      }
    }
    return ret.toString();
  }
}
