class Solution {
    public int countPartitions(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = 0;
            for (int j = 0; j <= i; j++) {
                left += nums[j];
            }
            int right = 0;
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            if ((left - right) % 2 == 0) {
                ret++;
            }
        }
        return ret;
    }
}