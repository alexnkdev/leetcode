class Solution {
  public int divide(int dividend, int divisor) {
    boolean negative = dividend < 0;
    if (divisor < 0) {
      if (negative) {
        negative = false;
      } else {
        negative = true;
      }
    }
    long dd = Math.abs((long) dividend);
    long dv = Math.abs((long) divisor);
    long sum = 0;
    long quotient = 0;

    long[] powers = new long[21];
    long[] quot = new long[21];
    powers[0] = dv;
    quot[0] = 1;
    for (int i = 1; i <= 20; i++) {
      powers[i] = powers[i - 1] + powers[i - 1];
      quot[i] = quot[i - 1] + quot[i - 1];
    }
    for (int i = 20; i >= 0; i--) {
      while (sum + powers[i] <= dd) {
        sum += powers[i];
        quotient += quot[i];
      }
    }
    if (negative) {
      quotient = -quotient;
    }
    if (quotient >= (1L << 31)) {
      return (int) ((1L << 31) - 1L);
    }
    if (quotient < -(1L << 31)) {
      return (int) (1L << 31);
    }
    return (int) quotient;
  }
}
