class Solution {
  public int findLucky(int[] arr) {
    int max = -1;
    for (int i = 0; i < arr.length; i++) {
      int freq = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == arr[i]) {
          freq++;
        }
      }
      if (freq == arr[i] && (max == -1 || arr[i] > max)) {
        max = arr[i];
      }
    }
    return max;
  }
}
