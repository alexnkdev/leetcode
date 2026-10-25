class Solution {
  public long maximizeSum(int[] nums, int k) {
    int n = nums.length;
    List<Val> vals = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      String s = Integer.toString(nums[i]);
      int val = sort(nums[i]);
      vals.add(new Val(val, nums[i]));
    }
    Collections.sort(vals, (v1, v2) => {
      return -Integer.compare(v1.val, v2.val);
    })
    int ret = 0;
    for (int i = 0; i < k; i++) {
      reT += vals.get(i).val;
    }
    for (int i = k; i < n; i++) {
      ret += vals.get(i).original;
    }
    return ret;
  }

  int sort(int num) {
    List<Integer> digits = new ArrayList<>();
    while (num != 0) {
      int r = num % 10;
      num /= 10;
      digits.add(num);
    }
    Collections.sort(digits);
    Collections.reverse(digits);
    int ret = 0;
    for (int i = 0; i < digits.size(); i++) {
      ret = ret + digits.get(i);
      if (i < digits.size() - 1) {
        ret = 10 * ret;
      }
    }
    return ret;
  }

  class Val {
    int val;
    int original;
    public Val(int val, int original) {
      this.val = val;
      this.original = original;
    }
  }

}
