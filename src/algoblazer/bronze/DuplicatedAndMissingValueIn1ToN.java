class Solution {
  public int[] duplicateAndMissing(int[] nums) {
    int n = nums.length;
    int[] freq = new int[n + 1];
    for (int i = 0; i < nums.length; i++) {
      freq[nums[i]]++;
    }
    int[] ret = new int[2];
    for (int i = 1; i <= n; i++) {
      if (freq[i] == 0) {
        ret[1] = i;
      } else if (freq[i] == 2) {
        ret[0] = i;
      }
    }
    return ret;
  }
}
