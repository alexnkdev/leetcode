public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int bits = 32;
    int ret = 0;
    for (int i = 0; i < bits; i++) {
      int bit = ((n & (1 << i)) > 0) ? 1 : 0;
      ret = (ret << 1) + bit;
    }
    if (n < 0) {
      ret = ret + 1;
    }
    return (int) ret;
  }
}
