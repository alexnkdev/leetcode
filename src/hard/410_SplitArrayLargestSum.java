class Solution {
  
  public int splitArray(int[] nums, int k) {
    
    int[] prefixSums = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
    }

    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
    }

    int ret = 0;
    int low = 0;
    int high = totalSum;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (isSplitPossible(nums, prefixSums, mid, k)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  boolean isSplitPossible(int[] nums, int[] prefixSums, int maxSum, int k) {

    boolean[][] ok = new boolean[nums.length + 1][k + 1];
    ok[0][0] = true;

    for (int i = 0; i <= nums.length; i++) {
      for (int kk = 1; kk <= k; kk++) {
        for (int j = 0; j <= i; j++) {
          int s = prefixSums[i] - prefixSums[j];
          if (s <= maxSum) {
            ok[i][kk] |= ok[j][kk - 1];
          }
        }
      }
    }

    return ok[nums.length][k];

  }

}
