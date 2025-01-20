package algorithms;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(-1); // head
		ListNode current = ret;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int val1 = l1.val;
			int val2 = l2.val;
			int newVal = (val1 + val2 + carry) % 10;
			carry = (val1 + val2 + carry) / 10;
			ListNode next = new ListNode(newVal);
			current.next = next;
			current = next;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode rem = l1 != null ? l1 : l2;
		while (rem != null) {
			int newVal = (rem.val + carry) % 10;
			carry = (rem.val + carry) / 10;
			ListNode next = new ListNode(newVal);
			current.next = next;
			current = next;
			rem = rem.next;
		}
		if (carry > 0) {
			ListNode next = new ListNode(1);
			current.next = next;
		}
		return ret.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
}
