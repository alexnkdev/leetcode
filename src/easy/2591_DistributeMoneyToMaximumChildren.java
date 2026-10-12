class Solution {
  public int distMoney(int money, int children) {
    if (money >= children * 8) {
      int remMoney = money - children * 8;
      if (remMoney == 0) {
        return children;
      }
      return children - 1;
    } else {
      int[] buckets = new int[children];
      if (money < children) {
        return -1;
      } 
      for (int i = 0; i < children; i++) {
        buckets[i] = 1;
      }
      money -= children;
      int cnt1 = children;
      int cnt8 = 0;
      for (int i = 0; i < children; i++) {
        if (money >= 7) {
          buckets[i] = 8;
          money -= 7;
          cnt1--;
          cnt8++;
        }
      }
      // now money < 7
      if (money == 3) {
        if (cnt1 > 1) {
          return cnt8;
        } else {
          if (cnt1 == children) {
            return -1;
          } else {
            return cnt8 - 1;
          }
        }
      } else {
        return cnt8;
      }
    }
  }

}
