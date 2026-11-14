class Solution {
  public int[] rangeSums(int[] nums, int[][] q) {
    int n = nums.length;
    int[] p = new int[n + 1];
    p[0] = 0;
    for (int i = 1; i <= n; i++) {
      p[i] = nums[i - 1] + p[i - 1];
    }

    int[] ret = new int[q.length];
    for (int i = 0; i < q.length; i++) {
      int left = q[i][0];
      int right = q[i][1];
      int sum = p[right + 1] - p[left];
      ret[i] = sum;
    }
    return ret;
  }
}
