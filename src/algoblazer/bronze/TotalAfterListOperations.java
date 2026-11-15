class Solution {
  public int totalAfterOperations(String[] op) {
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < op.length; i++) {
      String operation = op[i];
      if (operation.equals("+")) {
        int last1 = st.pop();
        int last2 = st.pop();
        st.push(last2);
        st.push(last1);
        st.push(last1 + last2);
      } else if (operation.equals("D")) {
        int last = st.peek();
        st.push(last * 2);
      } else if (operation.equals("C")) {
        st.pop();
      } else {
        st.push(Integer.parseInt(operation));
      }
    }
    int ret = 0;
    while (!st.isEmpty()) {
      ret += st.pop();
    }
    return ret;
  }
}
