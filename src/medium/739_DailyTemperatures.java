class Solution {
  
  public int[] dailyTemperatures(int[] t) {
    
    Stack<Temp> st = new Stack<Temp>();
    st.push(new Temp(t[0], 0, 0));
    int[] res = new int[t.length];
    for (int i = 1; i < t.length; i++) {
      int current = t[i];
      while (!st.isEmpty() && current > st.peek().temp) {
        Temp temp = st.pop();
        int diff = i - temp.day;
        res[temp.day] = diff;
      }
      st.push(new Temp(current, i, 0));
    }

    return res;

  }

  class Temp {
    int temp;
    int day;
    int diff;
    public Temp(int temp, int day, int diff) {
      this.temp = temp;
      this.day = day;
      this.diff = diff;
    }
  }

}
