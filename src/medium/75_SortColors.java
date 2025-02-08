class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int current = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[current++] = i;
            }
        }
    }
}