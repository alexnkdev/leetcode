class Solution {
  public int longestConsecutiveRun(int[] nums) {
    TreeSet<Integer> present = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      present.add(nums[i]);
    }
    Iterator<Integer> iter = present.iterator();

    Integer prev = null;

    Integer runStart = null;
    
    int maxRun = 0;
    while (iter.hasNext()) {
      int next = iter.next();
      if (prev == null) {
        runStart = next;
        maxRun = Math.max(maxRun, 1);
      } else {
        if (prev == next - 1) {
          int runLength = next - runStart + 1;
          maxRun = Math.max(maxRun, runLength);
        } else {
          int runEnd = prev;
          int runLength = runEnd - runStart + 1;
          maxRun = Math.max(maxRun, runLength);
          runStart = next;
        }
      }
      prev = next;
    }
    


    return maxRun;

  }
}
