class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans = Math.abs(nums[1] - nums[0]);
       for (int i = 0; i < nums.length; i++) {
           int current = nums[i];
           int next = i == nums.length - 1 ? nums[0] : nums[i + 1];
           ans = Math.max(ans, Math.abs(current - next));
       } 
       return ans;
    }
}