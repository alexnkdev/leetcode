package algorithms;

public class RemoveZeroSumConsecNodes {

	public ListNode removeZeroSumSublists(ListNode head) {
		while (true) {
			ListNode from = head;
			ListNode prev = null;
			boolean found = false;
			while (from != null) {
				ListNode last = from;
				int sum = 0;
				while (last != null) {
					sum = sum + last.val;
					if (sum == 0) {
						break;
					}
					last = last.next;
				}
				if (sum == 0 && last != null) {
					if (from == head) {
						head = last.next;
					} else {
						prev.next = last.next;
					}
					found = true;
					break;
				} else {
					prev = from;
					from = from.next;
				}
			}
			if (!found) {
				break;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
