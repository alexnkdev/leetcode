class Solution {
  public int[] nextLargerNodes(ListNode head) {
    
    ListNode current = head;
    int size = 0;
    while (current != null) {
      size++;
      current = current.next;
    }
    int[] ret = new int[size];

    Stack<Item> mst = new Stack<Item>();

    current = head;
    int index = 0;
    while (current != null) {
      while (!mst.isEmpty() && current.val > mst.peek().val) {
        int poppedIndex = mst.pop().index;
        ret[poppedIndex] = current.val;
      }
      mst.push(new Item(index, current.val));
      current = current.next;
      index++;
    }

    return ret;
  }

  class Item {
    int index;
    int val;
    public Item(int index, int val) {
      this.index = index;
      this.val = val;
    }
  }
}
