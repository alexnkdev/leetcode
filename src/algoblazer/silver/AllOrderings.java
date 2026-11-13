class Solution {
  public int[][] allOrderings(int[] nums) {
    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];
    List<List<Integer>> p = rec(nums, 0, used);
    int[][] ret = new int[p.size()][];
    for (int i = 0; i < p.size(); i++) {
      ret[i] = new int[p.get(i).size()];
      for (int j = 0; j < p.get(i).size(); j++) {
        ret[i][j] = p.get(i).get(j);
      }
    }
    return ret;
  }

  public List<List<Integer>> rec(int[] nums, int step, boolean[] used) {
    if (step == nums.length) {
      List<List<Integer>> ret = new ArrayList<>();
      ret.add(new ArrayList<>());
      return ret;
    }
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        used[i] = true;
        List<List<Integer>> sub = rec(nums, step + 1, used);
        for (List<Integer> subPerm : sub) {
          List<Integer> x = new ArrayList<>();
          x.add(nums[i]);
          x.addAll(subPerm);
          ret.add(x);
        }
        used[i] = false;
      }
    }
    return ret;
  }

}
