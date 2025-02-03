class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j + 1 < nums.length) {
                if (nums[j + 1] <= nums[j]) {
                    break;
                }
                j++;
            }
            int subAns = j - i + 1;
            j = i;
            while (j + 1 < nums.length) {
                if (nums[j + 1] >= nums[j]) {
                    break;
                }
                j++;
            }
            subAns = Math.max(subAns, j - i + 1);
            ret = Math.max(ret, subAns);
        }
        return ret;
    }
}