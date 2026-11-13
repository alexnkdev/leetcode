class Solution {
  public int countOneBits(int n) {
    int ret = 0;
    while (n != 0) {
      int r = n % 2;
      if (r == 1) {
        ret++;
      }
      n /= 2;
    }
    return ret;
  }
}
