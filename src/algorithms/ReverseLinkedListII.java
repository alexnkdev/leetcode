package algorithms;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode current = head;
		int i = 0;
		while (i < m) {
			current = current.next;
			i++;
		}
		while (i < n) {
			ListNode tmpNext = current.next;
			current = current.next;
		}
		return null;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
