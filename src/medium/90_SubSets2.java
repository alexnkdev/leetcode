class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        for (int set = 0; set < (1 << nums.length); set++) {
            List<Integer> subSet = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((set & (1 << i)) > 0) {
                    subSet.add(nums[i]);
                }
            }
            Collections.sort(subSet);
            ret.add(subSet);
        }
        return new ArrayList<>(ret);
    }
}