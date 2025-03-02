class Solution {
    public int countSubarrays(int[] nums) {
        int ret = 0;
        for (int start = 0; start <= nums.length - 3; start++) {
            int first = nums[start];
            int middle = nums[start + 1];
            int last = nums[start + 2];
            if ((first + last) * 2 == middle) {
                ret++;
            }
        }
        return ret;
    }
}