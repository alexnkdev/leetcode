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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode newHead = null;
        ListNode prevPairLast = null;
        while (current != null) {
            
            ListNode firstInPair = current;
            ListNode secondInPair = current.next;
            
            if (secondInPair == null) {
                break;
            }

            firstInPair.next = secondInPair.next;
            secondInPair.next = firstInPair;

            if (prevPairLast != null) {
                prevPairLast.next = secondInPair;
                prevPairLast = firstInPair;
            } else {
                newHead = secondInPair;
                prevPairLast = firstInPair;
            }


            current = firstInPair.next;

        }
        return newHead;
    }
}