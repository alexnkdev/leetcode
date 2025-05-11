import java.util.Iterator;
import java.util.TreeSet;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    TreeSet<TreeKey> heap = new TreeSet<>((i1, i2) -> {
      if (i1.value != i2.value) {
        return -Integer.compare(i1.value, i2.value);
      } else {
        return Integer.compare(i1.index, i2.index);
      }
    });
    for (int i = 0; i < nums.length; i++) {
      heap.add(new TreeKey(nums[i], i));
    }
    Iterator<TreeKey> iterator = heap.iterator();
    for (int i = 0; i < k - 1; i++) {
      iterator.next();
    }
    return iterator.next().value;
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
