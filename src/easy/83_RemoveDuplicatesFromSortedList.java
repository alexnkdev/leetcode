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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode ret = new ListNode();
        ListNode retCurrent = ret;
        while (current != null) {
            retCurrent.val = current.val;
            current = current.next;
            while (current != null && current.val == retCurrent.val) {
                current = current.next;
            }
            retCurrent.next = current;
            retCurrent = retCurrent.next;
        }
        return ret;
    }
}