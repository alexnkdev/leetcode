class Solution {

  private final ListNode head;
  private final Random random = new Random();

  public Solution(ListNode head) {
    this.head = head;
  }

  public int getRandom() {
    int result = head.val;
    int count = 1;
    
    ListNode current = head;
    while (current != null) {
      if (random.nextInt(count) == 0) {
        result = current.val;
      }
      count++;
      current = current.next;
    }

    return result;
  }

}
