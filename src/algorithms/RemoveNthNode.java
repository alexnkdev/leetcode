package algorithms;

public class RemoveNthNode {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current = head;
		ListNode nthfromtheend = null;
		int cnt = 0;
		while (current != null) {
			cnt++;
			if (cnt > n) {
				nthfromtheend = nthfromtheend.next;
			} else if (cnt == n) {
				nthfromtheend = head;
			}
			current = current.next;
		}
		if (nthfromtheend == null) {
			return null;
		}
		if (nthfromtheend == head) {
			return head.next;
		} else {
			nthfromtheend.next = nthfromtheend.next.next;
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
