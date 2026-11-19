class Solution {
  public int lastRemainingWeight(int[] w) {
    PriorityQueue<Item> pq = new PriorityQueue<>((v1, v2) -> {
      if (v1.val == v2.val) {
        return Integer.compare(v1.idx, v2.idx);
      }
      return -Integer.compare(v1.val, v2.val);
    });
    for (int i = 0; i < w.length; i++) {
      pq.add(new Item(w[i], i));
    }
    int idx = w.length;
    while (!pq.isEmpty()) {
      if (pq.size() == 1) {
        return pq.poll().val;
      }
      Item largest = pq.poll();
      Item secondLargest = pq.poll();
      if (largest.val > secondLargest.val) {
        pq.add(new Item(largest.val - secondLargest.val, idx++));
      }
    }
    return 0;
  }

  class Item {
    public int val;
    public int idx;
    public Item(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }
  }
}
