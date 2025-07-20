class Solution {
  public void nextPermutation(int[] nums) {
    if (nums.length == 1) {
      return;
    }
    int pivot = -1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        pivot = i;
        break;
      }
    }
    if (pivot == -1) {
      for (int i = 0; i < nums.length / 2; i++) {
        int t = nums[i];
        nums[i] = nums[nums.length - i - 1];
        nums[nums.length - i - 1] = t;
      }
      return;
    }
    int smallest = pivot + 1;
    for (int i = pivot + 1; i < nums.length; i++) {
      if (nums[i] < nums[smallest] && nums[i] > nums[pivot]) {
        smallest = i;
      }
    }
    int t = nums[pivot];
    nums[pivot] = nums[smallest];
    nums[smallest] = t;
    for (int i = pivot + 1; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          t = nums[i];
          nums[i] = nums[j];
          nums[j] = t;
        }
      }
    }
  }

}

  
