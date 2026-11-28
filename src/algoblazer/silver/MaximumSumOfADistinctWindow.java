class Solution {
    public long maxDistinctWindowSum(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long maxSum = 0;
        int distinct = 0;
        long windowSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while (i < n && j < n) {
            int val = nums[j];
            if (freq.getOrDefault(val, 0) == 0 && (j - i < k)) {
                distinct++;
                windowSum += val;
                freq.put(val, freq.getOrDefault(val, 0) + 1);
                j++;
            } else {
                if (freq.getOrDefault(nums[i], 0) == 1) {
                    distinct--;
                }
                windowSum -= nums[i];
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) - 1);
                i++;
            }
            if (distinct == k && j - i == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }
}
