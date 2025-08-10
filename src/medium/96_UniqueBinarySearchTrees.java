class Solution {

  Integer[] vals;

  public int numTrees(int n) {
    vals = new Integer[1 << n];
    return calc((1 << n) - 1, n);
  }

  public int calc(int mask, int n) {
    if (vals[mask] != null) {
      return vals[mask];
    }
    if (mask == 0) {
      return 1;
    }
    int ret = 0;
    for (int root = 0; root < n; root++) {
      if ((mask & (1 << root)) > 0) {
        int left_mask = mask;
        for (int i = 0; i < n; i++) {
          if (i >= root) {
            left_mask = left_mask & ~(1 << i);
          }
        }
        int right_mask = mask;
        for (int i = 0; i < n; i++) {
          if (i <= root) {
            right_mask = right_mask & ~(1 << i);
          }
        }
        int left_cnt = calc(left_mask, n);
        int right_cnt = calc(right_mask, n);
        ret += left_cnt * right_cnt;
      }
    }
    vals[mask] = ret;
    return ret;
  }

}
