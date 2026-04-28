class Solution {
    public int compareBitonicSums(int[] nums) {
      int n = nums.length;
      int hillIdx = -1;
      for (int i = 0; i < nums.length; i++) {
        boolean leftOk = i == 0 || nums[i] > nums[i - 1];
        boolean rightOk = i == n - 1 || nums[i] > nums[i + 1];
        if (leftOk && rightOk) {
          hillIdx = i;
          break;
        }
      }
      if (hillIdx < 0) {
        throw new RuntimeException();
      }
      long sumLeft = 0;
      long sumRight = 0;
      for (int i = 0; i < nums.length; i++) {
        if (i <= hillIdx) {
          sumLeft += nums[i];
        }
        if (i >= hillIdx) {
          sumRight += nums[i];
        }
      }
      if (sumLeft == sumRight) {
        return -1;
      }
      return sumLeft > sumRight ? 0 : 1; 
    }
}
