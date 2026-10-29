class Solution {
  public boolean isPalindrome(ListNode head) {
    List<Integer> arr = new ArrayList<>();
    ListNode current = head;
    while (current != null) {
      arr.add(current.val);
      current = current.next;
    }
    for (int i = 0; i < arr.size() / 2; i++) {
      int first = arr.get(i);
      int last = arr.get(arr.size() - i - 1);
      if (first != last) {
        return false;
      }
    }
    return true;
  }
}
