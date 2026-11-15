class Solution {
  public int bestDigitSumPair(int[] nums) {
    Map<Integer, List<Integer>> sumToIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int sum = digitSum(nums[i]);
      List<Integer> idxs = sumToIndex.get(sum);
      if (idxs == null) {
        idxs = new ArrayList<>();
      }
      idxs.add(i);
      sumToIndex.put(sum, idxs);
    }
    for (Integer sum : sumToIndex.keySet()) {
      List<Integer> idxs = sumToIndex.get(sum);
      Collections.sort(idxs, (val1, val2) -> {
        return -Integer.compare(nums[val1], nums[val2]);
      });
      sumToIndex.put(sum, idxs);
    }
    Integer max = null;
   // System.out.println(sumToIndex);
    for (Integer sum : sumToIndex.keySet()) {
      List<Integer> idxs = sumToIndex.get(sum);
      if (idxs.size() > 1) {
        Iterator<Integer> it = idxs.iterator();
        int first = nums[it.next()];
        int second = nums[it.next()];
        int sumVal = first + second;
        if (max == null || max < sumVal) {
          max = sumVal;
        }
      }
    }
    return max == null ? -1: max;
  }

  int digitSum(int x) {
    int ret = 0;
    while (x != 0) {
      ret += (x % 10);
      x /= 10;
    }
    return ret;
  }
}
