class Solution {
  public int maximumKRises(int k, int[] nums) {
    int n = nums.length;
    int[][] d = new int[n + 1][k + 1];
    d[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int kk = 0; kk <= k; kk++) {
        d[i][kk] = d[i - 1][kk];
        for (int prev = 1; prev < i; prev++) {
          int thisVal = nums[i - 1];
          int prevVal = nums[prev - 1];
          int score = thisVal - prevVal;

          if (kk > 0) {
            d[i][kk] = Math.max(d[i][kk], d[prev][kk - 1] + score);
          }
        }

      }
    }

    return d[nums.length][k];
  }
}
