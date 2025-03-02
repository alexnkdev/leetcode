class Solution {
    public int[] transformArray(int[] nums) {
        int cntEven = 0;
        int cntOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                cntEven++;
            } else {
                cntOdd++;
            }
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < cntEven; i++) {
            ret[i] = 0;
        }
        for (int i = cntEven; i < nums.length; i++) {
            ret[i] = 1;
        }
        return ret;
    }
}