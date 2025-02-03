class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int set = 0; set < (1 << n); set++) {
            List<Integer> subSet = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((set & (1 << i)) > 0) {
                    subSet.add(nums[i]);
                }
            }
            ret.add(subSet);
        }
        return ret;
    }
}