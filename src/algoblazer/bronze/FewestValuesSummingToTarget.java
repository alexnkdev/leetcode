class Solution {
  public int fewestValuesToTarget(int[] v, int t) {
    Integer[] d = new Integer[t + 1];
    d[0] = 0;
    for (int i = 1; i <= t; i++) {
      for (int k = 0; k < v.length; k++) {
        int other = i - v[k];
        if (i - v[k] >= 0 && d[other] != null) {
          d[i] = d[i] == null ? (d[other] + 1) : (Math.min(d[i], d[other] + 1));
        }
      }
    }
    return d[t] == null ? -1 : d[t];
  }
}
