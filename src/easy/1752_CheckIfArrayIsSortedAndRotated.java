class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = i == nums.length - 1 ? nums[0] : nums[i + 1];
            if (next < nums[i]) {
                cnt++;
            }
        }
        return cnt <= 1;
    }
}