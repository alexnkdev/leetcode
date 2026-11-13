class Solution {
  public int bestDigitSumPair(int[] nums) {
    Map<Integer, Set<Integer>> digitSumsToNum = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int sum = digitSum(nums[i]);
      Set<Integer> cur = digitSumsToNum.getOrDefault(sum, new TreeSet<>(
            new Comparator<Integer>() {
              public int compare(Integer firstIndex, Integer secondIndex) {
                if (nums[firstIndex] < nums[secondIndex]) {
                  return 1;
                }
                if (nums[firstIndex] > nums[secondIndex]) {
                  return -1;
                }
                return -Integer.compare(firstIndex, secondIndex);
              }
            }
            ));
      cur.add(i);
      digitSumsToNum.put(sum, cur);
    }

    Integer max = null;
    for (Integer sum : digitSumsToNum.keySet()) {
      if (digitSumsToNum.get(sum).size() < 2) {
        continue;
      }
      if (max == null || sum > max) {
        max = sum;
      }
    }

    if (max != null && digitSumsToNum.get(max).size() > 1) {
      Iterator<Integer> iter = digitSumsToNum.get(max).iterator();
      return nums[iter.next()] + nums[iter.next()];
    } else {
        return -1;
    }

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
