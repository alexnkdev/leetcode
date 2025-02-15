class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int start = nums[0];
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                int end = nums[i - 1];
                if (start != end) {
                    ret.add(start + "->" + end);
                } else {
                    ret.add("" + start);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return ret;
    }
}