package algorithms;

public class RemoveZeroSumConseqNodesFromLinkedList {

	public ListNode removeZeroSumSublists(ListNode head) {
		while (true) {
			ListNode start = head;
			boolean found = false;
			while (start != null && !found) {
				int sum = 0;
				ListNode current = start;
				while (current != null) {
					sum += current.val;
					current = current.next;
					if (sum == 0) {
						found = true;
						break;
					}
				}
				if (!found) {
					start = start.next;
				} else {
					start.next = current.next;
				}
			}
			if (!found) {
				break;
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
