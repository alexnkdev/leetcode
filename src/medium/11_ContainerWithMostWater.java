class Solution {
  public int maxArea(int[] height) {
    int high = 10000;
    int ret = 0;
    for (int mid = 1; mid <= high; mid++) {
      int leftmost = -1;
      for (int i = 0; i < height.length; i++) {
        if (height[i] >= mid) {
          leftmost = i;
          break;
        }
      }

      int rightmost = -1;
      for (int i = height.length - 1; i >= 0; i--) {
        if (height[i] >= mid) {
          rightmost = i;
          break;
        }
      }

      boolean can_do = leftmost != -1 && rightmost != -1;
      if (!can_do) {
        continue;
      } else {
        int square = (rightmost - leftmost) * Math.min(height[leftmost], height[rightmost]);
        ret = Math.max(ret, square);
      }
    }
    return ret;
  }
}
