class Solution {
  public int[] shiftZerosToEnd(int[] nums) {
    int place = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[place++] = nums[i];
      }
    }
    for (int i = place; i < nums.length; i++) {
      nums[i] = 0;
    }
    return nums;
  }
}
