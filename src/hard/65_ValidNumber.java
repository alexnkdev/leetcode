class Solution {
  public boolean isNumber(String s) {
    s = s.toUpperCase();
    int exp = s.indexOf('E');
    String nonExpPart;
    if (exp < 0) {
      nonExpPart = s;
    } else {
      nonExpPart = s.substring(0, exp);
    }

    if (!isInteger(nonExpPart) && !isDecimal(nonExpPart)) {
      return false;
    }

    if (exp < 0) {
      return true;
    }

    String expPart = s.substring(exp);
    if (isExpCorrect(expPart)) {
      return true;
    }
    return false;
  }

  public boolean isInteger(String s) {
    if (s.length() < 1) {
      return false;
    }
    char first = s.charAt(0);
    String digitsPart;
    if (isSign(first)) {
      digitsPart = s.substring(1);
    } else {
      digitsPart = s;
    }
    if (digitsPart.length() < 1) {
      return false;
    }
    for (int i = 0; i < digitsPart.length(); i++) {
      char c = digitsPart.charAt(i);
      if (!(c >= '0' && c <= '9')) {
        return false;
      }
    }
    return true;
  }

  public boolean isDecimal(String s) {
    if (s.length() < 1) {
      return false;
    }
    char first = s.charAt(0);
    String digitsPart;
    if (isSign(first)) {
      digitsPart = s.substring(1);
    } else {
      digitsPart = s;
    }
    if (digitsPart.length() < 1) {
      return false;
    }
    int numDots = 0;
    int numDigits = 0;
    for (int i = 0; i < digitsPart.length(); i++) {
      char ch = digitsPart.charAt(i);
      if (ch == '.') {
        numDots++;
      } else if (ch >= '0' && ch <= '9') {
        numDigits++;
      } else {
        return false;
      }
    }
    if (numDots != 1) {
      return false;
    }
    if (numDigits < 1) {
      return false;
    }
    return true;
  }

  boolean isSign(char c) {
    return c == '+' || c == '-';
  }

  boolean isExpCorrect(String s) {
    if (s.length() < 2) {
      return false;
    }
    char first = s.charAt(0);
    if (first != 'E') {
      return false;
    }
    return isInteger(s.substring(1));
  }

}
