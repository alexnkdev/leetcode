
class Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
        return new int[] { -1, -1 };
    }
    int starting = findStartingPos(nums, target);
    int ending = findEndingPos(nums, target);
    return new int[] {starting, ending};
  }

  int findStartingPos(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] >= target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    int ans = low >= 0 && low < nums.length && nums[low] == target ? low : -1;
    return ans;
  }

  int findEndingPos(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] <= target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    int ans = high >= 0 && nums[high] == target ? high : -1;
    return ans;
  }

}

