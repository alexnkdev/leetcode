class Solution {
  public int countCopyingRisks(int[] p, int range) {
    int ret = 0;
    for (int i = 0; i < p.length; i++) {
      for (int j = i + 1; j < p.length; j++) {
        if (p[i] == p[j]) {
          int dist = j - i;
          if (dist <= range) {
            ret++;
          }
        }
      }
    }
    return ret;
  }
}
