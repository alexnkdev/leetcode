
class Solution {
  public int search(int[] nums, int target) {
    int pivot = findPivot(nums, target);
    int ret;
    if (target >= nums[0] && target <= nums[pivot]) {
      ret = Arrays.binarySearch(nums, 0, pivot + 1, target);
    } else {
      ret = Arrays.binarySearch(nums, pivot + 1, nums.length, target);
    }
    return ret >= 0 ? ret : -1;
  }

  int findPivot(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (low == high - 1) {
        break;
      }
      if (nums[low] < nums[mid]) {
        // [5] 6 7 [8] 0 1 2
        // then pivot is in [mid..high]
        low = mid;
      } else if (nums[low] > nums[mid]) {
        // [5] 6 7 8 [0] 1 2 3 4
        // then pivot is in [low..mid]
        high = mid;
      }
    }
    return low;
  }

}
