class Solution {
  public int[] applyRangeIncrements(int[] nums, int[][] op) {
    int n = nums.length;

    for (int j = 0; j < nums.length; j++) {
    
      for (int i = 0; i < op.length; i++) {
        int[] operation = op[i];
        int l = operation[0];
        int r = operation[1];
        int d = operation[2];
        if (j >= l && j <= r) {
          nums[j] += d;
        }
      }
    }

    return nums;

  }
}
