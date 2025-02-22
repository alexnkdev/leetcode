class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean good = true;
            if (i - k >= 0) {
                good &= nums[i] > nums[i - k];
            }
            if (i + k < nums.length) {
                good &= nums[i] > nums[i + k];
            }
            if (good) {
                ret += nums[i];
            }
        }
        return ret;
    }
}