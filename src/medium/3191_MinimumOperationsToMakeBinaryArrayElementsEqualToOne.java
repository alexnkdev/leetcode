class Solution {
  public int minOperations(int[] nums) {
    int flips = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (i > nums.length - 3) {
          return -1;
        }
        flips++;
        nums[i] = 1;
        nums[i + 1] = 1 - nums[i + 1];
        nums[i + 2] = 1 - nums[i + 2];
      }
    }
    return flips;
  }
}
