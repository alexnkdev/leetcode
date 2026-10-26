class Solution {
  
  public long countSubarrays(int[] nums, int minK, int maxK) {
    
    long ret = 0L;

    int n = nums.length;
    Integer startSegment = null;
    for (int i = 0; i < n; i++) {
      if (!(nums[i] >= minK && nums[i] <= maxK)) {
        int endSegment = i;
        if (startSegment != null) {
          ret += num(startSegment, endSegment);
        }
        startSegment = null;
      } else {
        if (startSegment == null) {
          startSegment = i;
        }
      }
    }
    if (startSegment != null) {
      ret += num(startSegment, nums.length);
    }

    return ret;

  }

  long num(long start, long end) {
    
    long len = end - start;

    return (len + 1) * len / 2;

  }

}
