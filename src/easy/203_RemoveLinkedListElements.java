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
    public ListNode removeElements(ListNode head, int val) {
        ListNode newList = null;
        ListNode newListHead = null;
        ListNode current = head;
        while (current != null) {
            if (current.val != val) {
                ListNode newNode = new ListNode();
                newNode.val = current.val;
                if (newListHead == null) {
                    newList = newNode;
                    newListHead = newNode;
                } else {
                    newList.next = newNode;
                }
                newList = newNode;
            }
            current = current.next;
        }
        return newListHead;
    }
}