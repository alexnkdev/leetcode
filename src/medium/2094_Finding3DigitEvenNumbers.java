class Solution {
  public int[] findEvenNumbers(int[] digits) {
    Set<Integer> ret = new HashSet<>();
    for (int i = 0; i < digits.length; i++) {
      for (int j = 0; j < digits.length; j++) {
        for (int k = 0; k < digits.length; k++) {
          if (i != j && j != k && i != k) {
            if (digits[i] != 0) {
              int val = digits[i] * 100 + digits[j] * 10 + digits[k];
              if (val % 2 == 0) {
                ret.add(val);
              }
            }
          }
        }
      }
    }
    int[] arr = new int[ret.size()];
    int idx = 0;
    for (Integer x : ret) {
      arr[idx++] = x;
    }
    Arrays.sort(arr);
    return arr;
  }
}
