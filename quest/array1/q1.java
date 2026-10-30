class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ret = new int[nums.length * 2];
        for (int i = 0; i < ret.length; i++) {
            int idx = i < nums.length ? i : i - nums.length;
            ret[i] = nums[idx];
        }
        return ret;
    }
}
