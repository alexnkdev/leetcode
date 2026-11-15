class Solution {
  public String oneThroughKSubarrays(int[] perm) {

    boolean[] complete = new boolean[perm.length];

    for (int i = 0; i < perm.length; i++) {
      perm[i] = perm[i] - 1;
    }

    int[] pos = new int[perm.length];
    for (int i = 0; i < perm.length; i++) {
      pos[perm[i]] = i;
    }

    int ci = pos[0];
    int cj = pos[0];
    
    complete[0] = true;

    int n = perm.length;

    long[] p = new long[n + 1];
    p[0] = 0L;
    for (int i = 1; i <= n; i++) {
      p[i] = p[i - 1] + perm[i - 1];
    }

    for (int k = 1; k < n; k++) {
      int kPos = pos[k];
      ci = Math.min(ci, kPos);
      cj = Math.max(cj, kPos);
      int len = cj - ci + 1;
      long sum = p[cj + 1] - p[ci];
      long expected = (long) k * (k + 1) / 2;
      if (sum == expected) {
        complete[k] = true;
      }
    }

    StringBuilder str = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (complete[i]) {
        str.append("1");
      } else {
        str.append("0");
      }
    }
    return str.toString();

  }
}
