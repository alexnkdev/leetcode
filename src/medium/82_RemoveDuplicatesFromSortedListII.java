class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode current = head;
    int currentCount = 1;
    int lastVal = current.val;

    ListNode newListHead = null;
    ListNode newListCurrent = newListHead;

    while (current != null) {
      ListNode next = current.next;
      if (next == null || next.val != lastVal) {
        if (currentCount == 1) {
          ListNode newNode = new ListNode();
          newNode.val = lastVal;
          if (newListHead == null) {
            newListHead = newNode;
          }
          if (newListCurrent != null) {
            newListCurrent.next = newNode;
          }
          newListCurrent = newNode;
        }
        currentCount = 1;
        if (next != null) {
          lastVal = next.val;
        }
      } else if (next != null) {
        currentCount++;
      }
      current = next;
    }

    return newListHead;

  }
}
