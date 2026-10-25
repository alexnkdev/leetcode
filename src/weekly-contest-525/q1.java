class Solution {

  public int calculateScore(int a, int b) {
    String sa = Integer.toString(a, 2);
    String sb = Integer.toString(b, 2);
    int cntA = 0;
    int cntB = 0;
    for (int i = 0; i < sa.length(); i++) {
      if (sa.charAt(i) == '1') {
        cntA++;
      }
    }
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '1') {
        cntB++;
      }
    }
    if (cntA >= cntB) {
      return cntA * cntB;
    }
    return cntB / cntA;
  }

}
