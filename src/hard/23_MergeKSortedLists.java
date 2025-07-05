class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode current = null;
    ListNode head = null;
    while (true) {
      Integer minIndex = null;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] == null) {
          continue;
        }
        if (minIndex == null || lists[i].val < lists[minIndex].val) {
          minIndex = i;
        }
      }
      if (minIndex == null) {
        break;
      }
      ListNode min = lists[minIndex];
      ListNode newNode = new ListNode();
      newNode.val = min.val;
      if (head == null) {
        current = newNode;
        head = current;
      } else {
        current.next = newNode;
        current = newNode;
      }
      lists[minIndex] = lists[minIndex].next;
    }
    return head;
  }
}
