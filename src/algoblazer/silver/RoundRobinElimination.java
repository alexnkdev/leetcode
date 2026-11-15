class Solution {
  public String survivingLabel(String order) {
    int remA = 0;
    int remB = 0;
    for (char c : order.toCharArray()) {
      if (c == 'A') {
        remA++;
      } else {
        remB++;
      }
    }

    if (remA == 0) {
      return "B";
    }

    if (remB == 0) {
      return "A";
    }


  }
}
