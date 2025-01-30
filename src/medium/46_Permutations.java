class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> perms = gen(nums.length, used, nums);
        return perms;
    }

    private List<List<Integer>> gen(int k, boolean[] used, int[] nums) {
        if (k == 0) {
            List<Integer> perm = new ArrayList<>();
            List<List<Integer>> all = new ArrayList<>();
            all.add(perm);
            return all;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                List<List<Integer>> perms = gen(k - 1, used, nums);
                for (List<Integer> perm : perms) {
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(nums[i]);
                    ret.add(newPerm);
                }
                used[i] = false;
            }
        }
        return ret;
    }
}