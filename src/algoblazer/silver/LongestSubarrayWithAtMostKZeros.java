class Solution {
    public int longestSubarrayWithKZeros(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        // window [i, j)
        int window = 0;
        int ret = 0;
        while (i < n && j < n) {
            if (window <= k) {
                if (nums[j] == 0) {
                    window++;
                }
                j++;
            } else {
                if (nums[i] == 0) {
                    window--;
                }
                i++;
            }
            if (window <= k) {
                ret = Math.max(ret, j - i);
            }
        }
        return ret;
    }
}
