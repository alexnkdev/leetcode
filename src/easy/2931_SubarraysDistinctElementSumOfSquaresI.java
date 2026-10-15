class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                Set<Integer> s = new HashSet<>();
                for (int k = j; k <= i; k++) {
                    s.add(nums.get(k));
                }
                ret += s.size() * s.size();
            }
        }
        return ret;
    }
}
