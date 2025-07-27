class Solution {
  public int countHillValley(int[] nums) {

    int ret = 0;
    int current = 0;
    Integer previous = null;
    while (current < nums.length) {

      int j = current;
      while (j < nums.length && nums[j] == nums[current]) {
        j++;
      }

      if (j == nums.length) {
        break;
      }

      if (previous != null) {
        Integer next = nums[j];
        if (previous < nums[current] && next < nums[current]) {
          ret++;
        } else if (previous > nums[current] && next > nums[current]) {
          ret++;
        }
      }

      previous = nums[current];
      current = j;

    }

    return ret;

  }
}
