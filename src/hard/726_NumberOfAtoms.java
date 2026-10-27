class Solution {

  public String countOfAtoms(String formula) {
    Formula f = parse(0, formula);
    System.out.println(f.atomToCount);
    StringBuilder ret = new StringBuilder();
    for (String atom : f.atomToCount.keySet()) {
      String atomNameStr = atom;
      String cntStr = "";
      int cnt = f.atomToCount.get(atomNameStr);
      if (cnt > 1) {
        cntStr = "" + cnt;
      }
      ret.append(atomNameStr + cntStr);
    }
    return ret.toString();
  }

  Formula parse(int from, String formula) {
    
    int i = from;
    Formula ret = new Formula();
    while (i < formula.length()) {
      char c = formula.charAt(i);
        if (c == '(') {
          i++;
          Formula sub = parse(i, formula);
          i = sub.endIndex;
          String countStr = "";
          while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
            countStr += formula.charAt(i);
            i++;
          }
          if (countStr.isEmpty()) {
            countStr = "1";
          }
       
          Integer cntMultiplier = Integer.parseInt(countStr);
          for (String atomName : sub.atomToCount.keySet()) {
             ret.atomToCount.put(atomName,
                 ret.atomToCount.getOrDefault(atomName, 0) 
                 + sub.atomToCount.get(atomName) * cntMultiplier);
          }
        
        } else if (c == ')') { 
          i++;
          break;
        } else {
          String atomName = "" + c;
          i++;
          while (i < formula.length() && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
            atomName += formula.charAt(i);
            i++;
          }
          String countStr = "";
        
          while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
            countStr += formula.charAt(i);
            i++;
          }
            if (countStr.isEmpty()) {
            countStr = "1";
          }
          Integer cnt = Integer.parseInt(countStr);
          ret.atomToCount.put(atomName, ret.atomToCount.getOrDefault(atomName, 0) + cnt);
        }
    }
    ret.endIndex = i;
    return ret;

  }

  class Formula {
    Map<String, Integer> atomToCount = new TreeMap<>();
    int endIndex;
  }

}
