class Solution {
  public ListNode findMidpoint(ListNode head) {
    ListNode current = head;
    ListNode slow = head;
    int cc = 0;
    while (current != null) {
      if (cc % 2 == 1) {
        slow = slow.next;
      }
      cc++;
      current = current.next;
    }
    return slow;
  }
}
