class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    Stack<Integer> st = new Stack<Integer>();
    Map<Integer, Integer> ans = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      int current = nums2[i];
      while (!st.isEmpty() && current > st.peek()) {
        int prev = st.pop();
        ans.put(prev, current);
      }
      st.push(current);
    }
    
    int[] ret = new int[nums1.length];
    for (int i = 0; i < ret.length; i++) {
      ret[i] = ans.containsKey(nums1[i]) ? ans.get(nums1[i]) : -1;
    }
    return ret;

  }
}
