class NumArray {

  BIT bit;
  int[] nums;

  public NumArray(int[] nums) {
    bit = new BIT(nums);
    this.nums = nums;
  }

  public void update(int index, int val) {
    int delta = val - nums[index];
    nums[index] += delta;
    bit.add(index, delta);
  }

  public int sumRange(int left, int right) {
    return bit.sumRange(left, right);
  }

  static class BIT {
  
    int[] bit; // bit[r] = sum of the range [g(r), r]

    public BIT(int[] nums) {
      bit = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        add(i, nums[i]);
      }
    }

    public void add(int index, int delta) {
      while (index < bit.length) {
        bit[index] += delta;
        index = index | (index + 1);
      }
    }

    public int sumRange(int left, int right) {
      return sum(right) - sum(left - 1);
    }

    public int sum(int right) {
      int ret = 0;
      while (right >= 0) {
        ret += bit[right];
        right = (right & (right + 1)) - 1;
      }
      return ret;
    }

  }


}
