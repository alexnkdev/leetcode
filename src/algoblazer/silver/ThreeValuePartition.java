class Solution {
  public int[] threeValuePartition(int[] nums) {
    int zeroIdx = 0;
    int twoIdx = nums.length - 1;
    int i = 0;
    while (i < nums.length && i <= twoIdx) {
      int current = nums[i];
      if (current == 0) {
        int t = nums[zeroIdx];
        nums[zeroIdx] = 0;
        nums[i] = t;
        zeroIdx++;
        i++;
      } else if (current == 1) {
        i++;
      } else {
        int t = nums[twoIdx];
        nums[twoIdx ] = 2;
        nums[i] = t;
        twoIdx--;
      }
    }
    return nums;
  }
}
