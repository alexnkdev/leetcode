class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int start = 0; start <= nums.length - k; start++) {
            Set<Integer> subarrayNums = new HashSet<>();
            for (int i = start; i < start + k; i++) {
                int num = nums[i];
                subarrayNums.add(num);
            }
            for (Integer num : subarrayNums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        Integer max = null;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                max = max == null ? key : Math.max(max, key);
            }
        }
        return max == null ? -1 : max;
    }
}