class Solution {
  public ListNode reverseBetween(ListNode head, int leftIndex, int rightIndex) {
    ListNode current = head;
    ListNode headLast = null;
    int index = 0;
    while (current != null && index != leftIndex - 1) {
      headLast = current;
      current = current.next;
      index++;
    }
    if (current == null) {
      return head;
    }
    ListNode sublistHead = current;
    ListNode prev = null;
    while (true) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      if (index == rightIndex - 1) {
        break;
      }
      index++;
    }

    sublistHead.next = current;

    if (headLast == null) {
      return prev;
    }
    headLast.next = prev;
    return head;
  }

}

  

  
