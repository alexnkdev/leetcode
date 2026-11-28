class Solution {
    public int longestSubarrayTwoDistinct(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int distinct = 0;
        int ret = 0;
        while (i < n && j < n) {
            int val = nums[j];
            if (freq.getOrDefault(val, 0) == 0) {
                distinct++;
            }
            if (distinct <= 2) {
                freq.put(val, freq.getOrDefault(val, 0) + 1);
                j++;
            } else {
                if (freq.getOrDefault(val, 0) == 0) {
                    distinct--;
                }   
                if (freq.getOrDefault(nums[i], 0) == 1) {
                    distinct--;
                }
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) - 1);
                i++;
            }
            ret = Math.max(ret, j - i);
        }
        return ret;
    }
}
