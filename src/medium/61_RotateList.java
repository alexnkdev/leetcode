/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        if (head == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode current = head;
        while (current != null) {
            current = current.next;
            len++;
        }
        k = k % len;
        k = len - k;
        current = head;
        for (int i = 0; i < k; i++) {
            current = current.next;
            if (current == null) {
                current = head;
            }
        }
        ListNode newHead = current;
        for (int i = 0; i < len - 1; i++) {
            if (current.next == null) {
                current.next = head;
            }
            current = current.next;
        }
        current.next = null;
        return newHead;
    }
}