class Solution {
  public boolean isWithinOneEdit(String s0, String s1) {

    if (s0.equals(s1)) {
      return true;
    }

    if (isReplace(s0, s1)) {
      return true;
    }

    if (isInsert(s0, s1)) {
      return true;
    }

    if (isInsert(s1, s0)) {
      return true;
    }

    return false;
  }

  boolean isReplace(String from, String to) {
    if (from.length() != to.length()) {
      return false;
    }
    int diff = 0;
    for (int k = 0; k < from.length(); k++) {
      if (from.charAt(k) != to.charAt(k)) {
        diff++;
      }
    }
    return diff == 1;
  }

  boolean isInsert(String from, String to) {
    if (from.length() + 1 != to.length()) {
      return false;
    }
    int i = 0;
    int j = 0;
    int diff = 0;
    while (i < from.length() && j < to.length()) {
      char c1 = from.charAt(i);
      char c2 = to.charAt(j);
      if (c1 != c2) {
        j++;
        diff++;
      } else {
        i++;
        j++;
      }
    }
    if (diff == 1) {
        return true;
    }
    if (diff == 0) {
        return i == from.length();
    }
    return false;
  }

}
