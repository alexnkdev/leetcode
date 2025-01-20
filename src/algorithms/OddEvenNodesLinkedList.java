package algorithms;

public class OddEvenNodesLinkedList {

	public ListNode oddEvenList(ListNode head) {
		ListNode lastOdd = head;
		ListNode lastEven = head.next;
		ListNode current = head;
		ListNode firstEven = null;
		int currentIndex = 0;
		while (current != null) {
			System.out.println(current.val);
			ListNode remNext = current.next;
			if (currentIndex % 2 == 0) {
				lastOdd.next = current;
				lastOdd = current;
			} else {
				if (firstEven == null) {
					firstEven = current;
				}
				lastEven.next = current;
				lastEven = current;
			}
			current = remNext;
			currentIndex++;
		}
		lastOdd.next = firstEven;
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
