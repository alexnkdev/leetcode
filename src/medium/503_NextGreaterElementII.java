class Solution {
  public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> st = new Stack<>();
    int[] ret = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ret[i] = -1;
    }

    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      while (!st.isEmpty() && current > nums[st.peek()]) {
        int prev = st.pop();
        ret[prev] = current;
      }
      st.push(i);
    }

    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      while (!st.isEmpty() && current > nums[st.peek()]) {
        int prev = st.pop();
        ret[prev] = current;
      }
    }

    return ret;
  }
}
