class Solution {
  public int minProcessingRate(int[] b, int hours) {

    int low = 1;
    int high = 1000_000_000;
    while (low < high) {
       int mid = low + (high - low) / 2;
       int hoursRequired = calcHours(b, mid);
       if (hoursRequired <= hours) {
          high = mid;
       } else {
          low = mid + 1;
       }
    }

    return low;
  }

  int calcHours(int[] b, int k) {
    int ret = 0;
    for (int i = 0; i < b.length; i++) {
      ret += Math.ceil(1.0 * b[i] / k);
    }
    return ret;
  }


}
