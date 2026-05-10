class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int min = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] == 1 && nums[j] == 2) {
                    int abs = Math.abs(i - j);
                    min = min == -1 ? abs : Math.min(abs, min);
                }
            }
        }
        return min;
    }
}
