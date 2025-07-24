class Solution {
  public int trailingZeroes(int n) {
    int tot2 = 0;
    int tot5 = 0;
    for (int i = 2; i <= n; i++) {
      int k = i;
      while (k % 2 == 0) {
        tot2++;
        k /= 2;
      }
      k = i;
      while (k % 5 == 0) {
        tot5++;
        k /= 5;
      }
    }
    return Math.min(tot2, tot5);
  }
}
