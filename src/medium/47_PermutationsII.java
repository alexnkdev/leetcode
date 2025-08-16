class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int usedMask = 0;
        Set<List<Integer>> perms = generate(0, usedMask, nums);
        return new ArrayList<>(perms);
    }

    Set<List<Integer>> generate(int step, int usedMask, int[] nums) {
        if (step == nums.length) {
            Set<List<Integer>> ret = new HashSet<>();
            ret.add(new ArrayList<>());
            return ret;
        }
        Set<List<Integer>> ret = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            if ((usedMask & (1 << k)) == 0) {
                usedMask ^= (1 << k);
                Set<List<Integer>> sub = generate(step + 1, usedMask, nums);
                for (List<Integer> perm : sub) {
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(nums[k]);
                    ret.add(newPerm);
                }
                usedMask ^= (1 << k);
            }
        }
        return ret;
    }
}
