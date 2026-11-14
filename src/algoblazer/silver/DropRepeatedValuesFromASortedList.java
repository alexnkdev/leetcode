class Solution {
  public ListNode dropRepeated(ListNode head) {
    ListNode current = head;
    ListNode prevValid = null;
    ListNode newHead = null;
    while (current != null) {

      int cnt = 1;
      ListNode next = current.next;
      while (next != null && next.val == current.val) {
        next = next.next;
        cnt++;
      }

      if (cnt > 1) {
        if (prevValid != null) {
          prevValid.next = next;
        } else {
          newHead = next;
        }
      } else {
        if (newHead == null) {
          newHead = current;
        }
        prevValid = current;
      }

      current = next;

    }
    return newHead;
  }
}
