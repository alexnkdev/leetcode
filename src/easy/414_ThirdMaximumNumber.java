class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> maxes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (maxes.contains(nums[i])) {
                continue;
            }
            maxes.add(nums[i]);
            Collections.sort(maxes);
            Collections.reverse(maxes);
            if (maxes.size() > 3) {
                maxes = maxes.subList(0, 3);
            }
        }
        if (maxes.size() == 3) {
            return maxes.get(2);
        } else {
            return maxes.get(0);
        }
    }
}