class Solution {
  public String largestGoodInteger(String num) {
    Integer max = null;
    for (int i = 0; i <= num.length() - 3; i++) {
      String number = num.substring(i, i + 3);
      if (number.charAt(0) == number.charAt(1) && number.charAt(1) == number.charAt(2)) {
        Integer val = Integer.parseInt(number);
        if (max == null || val > max) {
          max = val;
        }
      }
    }
    if (max == null) {
      return "";
    }
    String ret = max.toString();
    while (ret.length() < 3) {
      ret = "0" + ret;
    }
    return ret;
  }
}
