/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1 = 0;
        ListNode currentA = headA;
        while (currentA != null) {
            cnt1++;
            currentA = currentA.next;
        }
        int cnt2 = 0;
        ListNode currentB = headB;
        while (currentB != null) {
            cnt2++;
            currentB = currentB.next;
        }
        currentA = headA;
        for (int i = 0; i < cnt1 - cnt2; i++) {
            currentA = currentA.next;
        }
        currentB = headB;
        for (int i = 0; i < cnt2 - cnt1; i++) {
            currentB = currentB.next;
        }
        while (currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }
}