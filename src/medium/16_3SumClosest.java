class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer best = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    best = best == null || Math.abs(target - best) > Math.abs(target - sum) ? sum : best;
                }
            }
        }
        return best;
    }
}