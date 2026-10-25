class Solution {
  
  int MAX = 9;
  
  public String getPermutation(int n, int k) {
    int[] fact = new int[MAX + 1];
    fact[0] = 1;
    for (int i = 1; i <= MAX; i++) {
      fact[i] = fact[i - 1] * i;
    }
    int totalCount = k;
    int currentCount = 0;
    String ret = "";
    boolean[] used = new boolean[n];
    for (int i = 0; i < n; i++) {
      int lengthLeft = n - i - 1;
      int order = 0;
      while (currentCount + fact[lengthLeft] < totalCount) {
        order++;
        currentCount += fact[lengthLeft];
      }
      int current = 0;
      int digit = 0;
      for (int j = 0; j < n; j++) {
        if (!used[j]) {
          if (current == order) {
            used[j] = true;
            digit = j + 1;
            break;
          }
          current++;
        }
      }
      ret = ret + "" + digit;
    }
    return ret;

  }

}
