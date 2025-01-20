import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> prevNodes = new ArrayList()<>();
        ListNode prevNode = null;
        ListNode current = head;
        int len = 0;
        prevNodes.add(null);
        while (current != null) {
            prevNode = current;
            current = current.next;
            prevNodes.add(prevNode);
            len++;
        }
        int targetIndex = len - n;
        if (targetIndex == 0) {
            return head.next;
        }
        prevNodes.get(targetIndex).next = prevNodes.get(targetIndex).next.next;
        return head;
    }
}