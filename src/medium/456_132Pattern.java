class Solution {
  public boolean find132pattern(int[] nums) {
    Stack<Integer> st = new Stack<>();
    Integer middle = null;    
    for (int i = nums.length - 1; i >= 0; i--) {
      int current = nums[i];

      if (middle != null && nums[i] < middle) {
        return true;
      }

      while (!st.isEmpty() && current > st.peek()) {
        middle = st.pop();
      }

      st.push(current);
    }

    return false;
  }
}
