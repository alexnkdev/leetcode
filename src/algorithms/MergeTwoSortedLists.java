package algorithms;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode current1 = l1;
		ListNode current2 = l2;
		ListNode ret = new ListNode(-1);
		ListNode current = ret;
		while (current1 != null && current2 != null) {
			if (current1.val < current2.val) {
				current.next = new ListNode(current1.val);
				current1 = current1.next;
			} else {
				ret.next = new ListNode(current2.val);
				current2 = current2.next;
			}
			current = current.next;
		}
		while (current1 != null) {
			current.next = new ListNode(current1.val);
			current1 = current1.next;
			current = current.next;
		}
		while (current2 != null) {
			current.next = new ListNode(current2.val);
			current2 = current2.next;
			current = current.next;
		}
		return current.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
