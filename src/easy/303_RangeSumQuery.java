class NumArray {

  private int[] prefixSums;

  public NumArray(int[] nums) {
    prefixSums = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
    }
  }

  public int sumRange(int left, int right) {
    return prefixSums[right + 1] - prefixSums[left];
  }

}
