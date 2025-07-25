class Solution {
  public int maxSum(int[] nums) {
    Set<Integer> taken = new HashSet<>();
    int sum = 0;
    boolean found = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0 && !taken.contains(nums[i])) {
        sum += nums[i];
        taken.add(nums[i]);
        found = true;
      }
    }
    if (!found) {
      int max = nums[0];
      for (int i = 0; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
      }
      return max;
    }
    return sum;
  }
}
