class Solution {
  public void sortColors(int[] nums) {
    int next_0 = 0;
    int next_2 = nums.length - 1;
    int current = 0;
    while (current <= next_2) {
      if (nums[current] == 0) {
        int temp = nums[next_0];
        nums[next_0] = nums[current];
        nums[current] = temp;
        next_0++;
        current++;
      } else if (nums[current] == 1) {
        current++;
      } else {
        int temp = nums[next_2];
        nums[next_2] = nums[current];
        nums[current] = temp;
        next_2--;
      }
    }
  }
}
