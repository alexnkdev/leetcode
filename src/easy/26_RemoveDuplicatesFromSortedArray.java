class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int totalUnique = 0;
        while (i < nums.length) {
            int take = nums[i];
            totalUnique++;
            nums[totalUnique - 1] = take;
            while (i < nums.length && nums[i] == take) {
                i++;
            }
        }
        return totalUnique;
    }
}