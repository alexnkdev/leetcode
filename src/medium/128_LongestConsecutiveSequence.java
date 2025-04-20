class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> vals = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      vals.add(nums[i]);
    }
    int ret = 0;
    Set<Integer> used = new HashSet<>();
    for (Integer current : vals) {
      if (used.contains(current)) {
        continue;
      }
      used.add(current);
      int totalChainLength = 0;
      int curLeft = current;
      while (vals.contains(curLeft - 1)) {
        curLeft--;
        used.add(curLeft);
      }
      int curRight = current;
      while (vals.contains(curRight + 1)) {
        curRight++;
        used.add(curRight);
      }
      totalChainLength = curRight - curLeft + 1;
      ret = Math.max(ret, totalChainLength);
    }
    return ret;
  }
}
