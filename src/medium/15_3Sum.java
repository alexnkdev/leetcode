class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnts.put(nums[i], cnts.getOrDefault(nums[i], 0) + 1);
        }
        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int remaining = 0 - nums[i] - nums[j];
                if (cnts.containsKey(remaining)) {
                    int amountAvailable = cnts.get(remaining);
                    int amountRequired = 1;
                    if (nums[i] == remaining) {
                        amountRequired++;
                    }
                    if (nums[j] == remaining) {
                        amountRequired++;
                    }
                    if (amountAvailable >= amountRequired) {
                        List<Integer> triple = Arrays.asList(nums[i], nums[j], remaining);
                        Collections.sort(triple);
                        ret.add(triple);
                    }
                }
            }
        }
        return new ArrayList<>(ret);
    }
}