class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> vals = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      vals.add(nums[i]);
    }
    int ret = 0;
    for (Integer current : vals) {
      if (vals.contains(current - 1)) {
        continue;
      }
      int totalChainLength = 0;
      int curRight = current;
      while (vals.contains(curRight + 1)) {
        curRight++;
      }
      totalChainLength = curRight - current + 1;
      ret = Math.max(ret, totalChainLength);
    }
    return ret;
  }
}
