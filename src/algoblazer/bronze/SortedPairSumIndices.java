class Solution {
  public int[] sortedPairSumIndices(int[] numbers, int target) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      freq.put(numbers[i], freq.getOrDefault(numbers[i], 0) + 1);
    }

    for (int i = 0; i < numbers.length; i++) {
      int a = numbers[i];
      int b = target - numbers[i];
      if (a != b && freq.containsKey(b)) {
        int otherIndex = 0;
        for (int j = 0; j < numbers.length; j++) {
          if (numbers[j] == b) {
            otherIndex = j;
          }
        }
        if (i < otherIndex) {
          return new int[] { i, otherIndex };
        } else {
          return new int[] { otherIndex, i };
        }
      } else {
        Integer freqB = freq.get(b);
        if (freqB != null && freqB > 1) {
          int otherIndex = 0;
          for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] == b && j != i) {
              otherIndex = j;
            }
          }
          if (i < otherIndex) {
            return new int[] { i, otherIndex };
          } else {
            return new int[] { otherIndex, i };
          }
        }
      }
    }
    return new int[] {};
  }
}
