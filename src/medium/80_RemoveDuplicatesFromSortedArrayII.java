class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int pos = 0;
        while (i < nums.length) {
            int current = nums[i];
            int j = i;
            while (j < nums.length && nums[j] == current) {
                j++;
            }
            int len = Math.min(2, j - i);
            for (int k = pos; k < pos + len; k++) {
                nums[k] = current;
            }
            pos += len;
            i = j;
        }
        return pos;
    }
}