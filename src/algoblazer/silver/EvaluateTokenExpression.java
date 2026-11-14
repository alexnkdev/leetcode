class Solution {
  public int evaluateTokens(String[] tokens) {
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {
      String t = tokens[i];
      if (isOperator(t)) {
        Integer b = st.pop();
        Integer a = st.pop();
        Integer result = apply(a, b, t);
        st.push(result);
      } else {
        st.push(Integer.parseInt(t));
      }
    }
    if (st.size() != 1) {
      throw new RuntimeException();
    }
    return st.pop();
  }

  int apply(Integer a, Integer b, String operator) {
    char c = operator.charAt(0);
    if (c == '+') {
      return a + b;
    } else if (c == '-') {
      return a - b;
    } else if (c == '*') {
      return a * b;
    } else if (c == '/') {
      return a / b;
    }
    throw new RuntimeException();
  }

  boolean isOperator(String x) {
    if (x.length() != 1) {
        return false;
    }
    char c = x.charAt(0);
    return c == '+' || c == '-' || c == '*' || c == '/';
  }
}
