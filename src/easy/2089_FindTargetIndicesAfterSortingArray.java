class Solution {
  public List<Integer> targetIndices(int[] nums, int target) {
    Arrays.sort(nums);
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        ret.add(i);
      }
    }
    return ret;
  }
}
