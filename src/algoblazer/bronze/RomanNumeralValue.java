class Solution {
  public int romanNumeralValue(String s) {
    int ret = 0;
    int i = 0;
    List<Val> values = new ArrayList<>();
    values.add(new Val("IV", 4));
    values.add(new Val("IX", 9));  
    values.add(new Val("XL", 40));  
    values.add(new Val("XC", 90));  
    values.add(new Val("CD", 400));  
    values.add(new Val("CM", 900));  
    values.add(new Val("I", 1));  
    values.add(new Val("V", 5));  
    values.add(new Val("X", 10));  
    values.add(new Val("L", 50));  
    values.add(new Val("C", 100));  
    values.add(new Val("D", 500));  
    values.add(new Val("M", 1000));  
    while (i < s.length()) {
      for (Val val : values) {
        if (i + val.sub.length() <= s.length() && s.substring(i, i + val.sub.length()).equals(val.sub)) {
          ret += val.val;
          i += val.sub.length();
          break;
        }
      }
    }
    return ret;
  }

  class Val {
    String sub;
    int val;
    public Val(String sub, int val) {
      this.sub = sub;
      this.val = val;
    }
  }
}
