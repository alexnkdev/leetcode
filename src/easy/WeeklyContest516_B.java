class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<List<Integer>> ranges = new ArrayList<>();
        Integer currentMissingRangeStart = null;
        Integer currentMissingRangeEnd = null;
        for (int x = lower; x <= upper; x++) {
            if (set.contains(x)) {
                if (currentMissingRangeStart != null) {
                    ranges.add(List.of(currentMissingRangeStart, currentMissingRangeEnd));
                    currentMissingRangeStart = null;
                }
            } else {
                if (currentMissingRangeStart == null) {
                    currentMissingRangeStart = x;
                }
                currentMissingRangeEnd = x;
            }
        }
        if (currentMissingRangeStart != null) {
            ranges.add(List.of(currentMissingRangeStart, currentMissingRangeEnd));
        }
        return ranges;
    }
}
