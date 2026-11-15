class Solution {
  public String expandRepeats(String s) {
    Result r = expand(s, 0);
    return r.val;
  }

  public Result expand(String s, int idx) {
    if (idx == s.length()) {
      return null;
    }

    StringBuilder ret = new StringBuilder();
    
    int i = idx;
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (ch >= '0' && ch <= '9') {
        String multiplier = "";
        while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
          multiplier += s.charAt(i);
          i++;
        }
        // i is at "["
        i++;
        Result sub = expand(s, i);
        Integer mult = Integer.parseInt(multiplier);
        for (int k = 0; k < mult; k++) {
          ret.append(sub.val);
        }
        i = sub.lastIdx + 1;
      } else {
        if (ch == ']') {
          return new Result(ret.toString(), i);
        } else {
          ret.append(ch);
          i++;
        }
      }
    }
    return new Result(ret.toString(), i);
  }

  class Result {
    public String val;
    public int lastIdx;

    public Result(String val, int lastIdx) {
      this.val = val;
      this.lastIdx = lastIdx;
    }
  }
}
