class Solution {
    public void moveZeroes(int[] nums) {
        int currentFreePos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currentFreePos] = nums[i];
                currentFreePos++;
            }
        }
        for (int i = currentFreePos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}