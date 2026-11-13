class Solution {
  
  int MOD = 1000_000_000 + 7;

  public int[] modPow(int[][] q) {
    int[] ret = new int[q.length];
    for (int i = 0; i < q.length; i++) {
      ret[i] = (int) calcModPow(q[i][0], q[i][1], MOD);
    }
    return ret;
  }

  long calcModPow(int a, int b, int m) {
    if (b == 1) {
      return a % m;
    }
    if (b == 0) {
      return 1;
    }
    if (b % 2 == 1) {
      long sub = calcModPow(a, b / 2, m);
      return (((sub * sub) % m) * a) % m;
    } else {
      long sub = calcModPow(a, b / 2, m);
      return (sub * sub) % m;
    }
  }

}
