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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode currentFirst = l1;
        ListNode currentSecond = l2;

        ListNode root = null;
        ListNode prev = null;

        int carry = 0;

        while (currentFirst != null || currentSecond != null || carry != 0) {
            
            int sum = 0;
            if (currentFirst != null) {
                sum += currentFirst.val;
            }

            if (currentSecond != null) {
                sum += currentSecond.val;
            }

            sum += carry;
            
            int digitValue = sum % 10;

            ListNode digitNode = new ListNode();
            digitNode.val = digitValue;

            if (root == null) {
                root = digitNode;
            } else {
                prev.next = digitNode;
            }

            carry = sum / 10;

            if (currentFirst != null) {
                currentFirst = currentFirst.next;
            }

            if (currentSecond != null) {
                currentSecond = currentSecond.next;
            }

            prev = digitNode;
        }

        return root;

    }
}
