class Solution {
  public int lastRemainingWeight(int[] weights) {
    List<Integer> w = new ArrayList<>();
    for (int i = 0; i < weights.length; i++) {
      w.add(weights[i]);
    }

    while (true) {
      Integer max1 = null;
      Integer max2 = null;
      for (int i = 0; i < w.size(); i++) {
        int val = w.get(i);
        if (max1 == null || val > max1) {
          max2 = max1;
          max1 = val;
        } else {
          if (max2 == null || val > max2) {
            max2 = val;
          }
        }
      }
      List<Integer> nw = new ArrayList<>();
      int del = 0;
      for (Integer x : w) {
        if (del < 2 && !x.equals(max1) && !x.equals(max2)) {
          nw.add(x);
          del++;
        }
      }
      if (!max1.equals(max2)) {
        if (max2 != null) {
          nw.add(max1 - max2);
        } else {
          nw.add(max1);
        }
      } 
      w = nw;
      if (w.size() <= 1) {
        break;
      }
    }

    if (w.size() == 1) {
      return w.get(0);
    }
    return 0;
  }
}
