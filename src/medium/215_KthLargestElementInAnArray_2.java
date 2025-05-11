import java.util.TreeSet;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    TreeSet<TreeKey> minHeap = new TreeSet<>((i1, i2) -> {
      if (i1.value != i2.value) {
        return Integer.compare(i1.value, i2.value);
      } else {
        return Integer.compare(i1.index, i2.index);
      }
    });
    for (int i = 0; i < nums.length; i++) {
      minHeap.add(new TreeKey(nums[i], i));
      if (minHeap.size() > k) {
        minHeap.pollFirst();
      }
    }
    return minHeap.first().value;
  }

  static class TreeKey {
    int value;
    int index;

    public TreeKey(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
