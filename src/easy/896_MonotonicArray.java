class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        String direction = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (direction != null && direction.equals("increasing") && nums[i] < nums[i - 1]) {
                return false;
            }
            if (direction != null && direction.equals("decreasing") && nums[i] > nums[i - 1]) {
                return false;
            }
            if (direction == null) {
                direction = nums[i] > nums[i - 1] ? "increasing" : "decreasing";
            }
        }
        return true;
    }
}