class Solution {

  int length;
  ListNode head;

  public Solution(ListNode head) {
    length = 0;
    ListNode current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    this.head = head;
  }

  public int getRandom() {
    ListNode current = head;
    int pos = new Random().nextInt(length);
    int index = 0;
    while (index != pos) {
      index++;
      current = current.next;
    }
    return current.val;
  }

}
