class Solution {
    public int removeElement(int[] nums, int val) {
        int currentFreePos = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentFreePos] = nums[i];
                currentFreePos++;
                ret++;
            }
        }
        return ret;
    }
}