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
    public ListNode partition(ListNode head, int x) {
        ListNode firstListHead = null;
        ListNode secondListHead = null;
        ListNode firstListCurrent = null;
        ListNode secondListCurrent = null;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (firstListHead == null) {
                    firstListHead = new ListNode();
                    firstListHead.val = current.val;
                    firstListCurrent = firstListHead;
                } else {
                    firstListCurrent.next = new ListNode();
                    firstListCurrent.next.val = current.val;
                    firstListCurrent = firstListCurrent.next;
                }
            } else {
                if (secondListHead == null) {
                    secondListHead = new ListNode();
                    secondListHead.val = current.val;
                    secondListCurrent = secondListHead;
                } else {
                    secondListCurrent.next = new ListNode();
                    secondListCurrent.next.val = current.val;
                    secondListCurrent = secondListCurrent.next;
                }
            }
            current = current.next;
        }
        if (firstListHead == null) {
            return secondListHead;
        }
        if (secondListHead == null) {
            return firstListHead;
        }
        firstListCurrent.next = secondListHead;
        return firstListHead;
    }
}