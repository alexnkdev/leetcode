class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[i] = nums[(i + nums[i]) % nums.length];
            } else if (nums[i] < 0) {
                result[i] = nums[(i - Math.abs(nums[i] % nums.length) + nums.length) % nums.length];
            } else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}