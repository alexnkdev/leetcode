class Solution {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    int n = nums.length;
    int max_target = 100 * 200;
    boolean[][] ok = new boolean[n + 1][max_target];
    ok[0][0] = true;
    for (int i = 1; i <= n; i++) {
      for (int t = 0; t < max_target; t++) {
        ok[i][t] = ok[i - 1][t];
        if (t - nums[i - 1] >= 0) {
          ok[i][t] |= ok[i - 1][t - nums[i - 1]];
        }
      }
    }
    return ok[n][target];
  }
}
