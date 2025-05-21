class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Map<Long, Integer> freq = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (freq.get((long) nums[i]) == null) {
        freq.put((long) nums[i], 1);
      } else {
        freq.put((long) nums[i], freq.get((long) nums[i]) + 1);
      }
    }
    Set<List<Integer>> ret = new HashSet<>();
    for (int a = 0; a < nums.length; a++) {
      for (int b = a + 1; b < nums.length; b++) {
        for (int c = b + 1; c < nums.length; c++) {
          long left = target - (long) nums[a] - (long) nums[b] - (long) nums[c];
          int freq_needed = 1;
          if (left == nums[a]) {
            freq_needed++;
          }
          if (left == nums[b]) {
            freq_needed++;
          }
          if (left == nums[c]) {
            freq_needed++;
          }
          if (freq.get(left) != null && freq.get(left) >= freq_needed) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[a]);
            l.add(nums[b]);
            l.add(nums[c]);
            l.add((int) left);
            Collections.sort(l);
            ret.add(l);
          }
        }
      }
    }
    return new ArrayList<>(ret);
  }
}
