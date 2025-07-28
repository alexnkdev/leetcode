class Solution {
  public int countMaxOrSubsets(int[] nums) {
    int n = nums.length;
    int max = 0;
    int maxCnt = 0;
    for (int mask = 0; mask < (1 << n); mask++) {
      int val = funcValue(nums, mask);
      if (val == max) {
        maxCnt++;
      } else if (val > max) {
        max = val;
        maxCnt = 1;
      }
    }
    return maxCnt;
  }

  int funcValue(int[] nums, int mask) {
    int ret = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((mask & (1 << i)) > 0) {
        ret = ret | nums[i];
      }
    }
    return ret;
  }
}
