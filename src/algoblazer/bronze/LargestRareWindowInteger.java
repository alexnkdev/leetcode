class Solution {
  public int largestRareWindowInteger(int[] nums, int window) {
    if (window == 1 || window == nums.length) {
      int[] cnt = new int[100000 + 1];
      for (int i = 0; i < nums.length; i++) {
        cnt[nums[i]]++;
      }
      int max = -1;
      for (int i = 0; i < nums.length; i++) {
        if (cnt[nums[i]] == 1) {
          max = max == -1 ? nums[i] : Math.max(max, nums[i]);
        }
      }
      return max;
    } else {
      int option1 = nums[0];
      int option2 = nums[nums.length - 1];
      if (option1 == option2) {
        return -1;
      }

      boolean option1ok = true;
      boolean option2ok = true;
      
      for (int k = 0; k < nums.length; k++) {
        if (k != 0 && nums[k] == option1) {
          option1ok = false;
        }
        if (k != nums.length - 1 && nums[k] == option2) {
          option2ok = false;
        }
      }

      if (option1ok && option2ok) {
        return Math.max(option1, option2);
      }

      if (option1ok) {
        return option1;
      }

      if (option2ok) {
        return option2;
      }

      return -1;
    }
  }
}
