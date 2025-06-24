class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (kDistant(nums, i, key, k)) {
        ret.add(i);
      }
    }
    return ret;
  }

  boolean kDistant(int[] nums, int index, int key, int k) {
    for (int j = index - k; j <= index + k; j++) {
      if (j < 0 || j >= nums.length) {
        continue;
      }
      if (nums[j] == key) {
        return true;
      }
    }
    return false;
  }
}
