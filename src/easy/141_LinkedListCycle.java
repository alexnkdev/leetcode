/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode currentSlow = head;
        ListNode currentFast = head;
        while (currentSlow != null && currentFast != null) {
            currentFast = currentFast.next;
            if (currentSlow == currentFast) {
                return true;
            }
            if (currentFast != null) {
                currentFast = currentFast.next;
            }
            currentSlow = currentSlow.next;
        }
        return false;
    }
}