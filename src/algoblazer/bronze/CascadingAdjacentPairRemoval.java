class Solution {
  public String reduceString(String s) {
    Stack<Character> st = new Stack<>();
    for (char c : s.toCharArray()) {
      if (st.isEmpty()) {
        st.push(c);
      } else {
        char prev = st.peek();
        int val1 = (int)(prev - 'a');
        int val2 = (int)(c - 'a');
        boolean good = (val1 + 1) % 26 == val2 || (val1 - 1 + 26) % 26 == val2;
        if (good) {
          st.pop();
        } else {
          st.push(c);
        }
      }
    }
    StringBuilder res = new StringBuilder();
    while (!st.isEmpty()) {
      res.append(st.pop());
    }
    return res.reverse().toString();
  }
}
