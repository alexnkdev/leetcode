class Solution {

  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    Stack<Element> st = new Stack<>();
    long ret = 0L;
    int MOD = 1000000000 + 7;
    for (int i = 0; i < arr.length; i++) {
      int current = arr[i];
      while (!st.isEmpty() && current < st.peek().val) {
        Element popped = st.pop();
        if (st.isEmpty()) {
          ret = (ret + (long) popped.val * (popped.fromIndex + 1) * (i - popped.fromIndex)) % MOD;
        } else {
          int previousIdx = st.peek().fromIndex;
          ret = (ret + (long) popped.val * (popped.fromIndex - previousIdx) * (i - popped.fromIndex)) % MOD;
        }

      }
      st.push(new Element(current, i));
    }
    while (!st.isEmpty()) {
      Element popped = st.pop();
        if (st.isEmpty()) {
            ret = (ret + (long) popped.val * (popped.fromIndex + 1) * (arr.length - popped.fromIndex)) % MOD;
        } else {
            int previousIdx = st.peek().fromIndex;
            ret = (ret + (long) popped.val * (popped.fromIndex - previousIdx) * (arr.length - popped.fromIndex)) % MOD;
        }
    }
    return (int) ret;
  }

  class Element {
    int val;
    int fromIndex;

    public Element(int val, int fromIndex) {
      this.val = val;
      this.fromIndex = fromIndex;
    }

    public String toString() {
      return "[" + val + ", " + fromIndex + "]";
    }
  }

}
