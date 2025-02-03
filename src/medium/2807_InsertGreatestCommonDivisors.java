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

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            ListNode first = current;
            ListNode second = current.next;

            ListNode gcdNode = new ListNode();
            gcdNode.val = gcd(first.val, second.val);

            first.next = gcdNode;
            gcdNode.next = second;

            current = second;
        }
        return head;
    }
}