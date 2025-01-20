package algorithms;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		while (current != null && current.next != null) {
			if (prev != null) {
				ListNode afterCurrent = current.next;
				ListNode afterAfterCurrent = current.next.next;
				prev.next = afterCurrent;
				current.next = afterAfterCurrent;
				afterCurrent.next = current;
				current = prev.next.next;
			} else {
				ListNode afterCurrent = current.next;
				ListNode afterAfterCurrent = current.next.next;
				head = afterCurrent;
				current.next = afterAfterCurrent;
				afterCurrent.next = current;
				current = head.next;
			}
		}
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
}
