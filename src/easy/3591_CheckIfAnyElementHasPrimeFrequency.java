import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean checkPrimeFrequency(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (freq.get(nums[i]) == null) {
        freq.put(nums[i], 0);
      }
      freq.put(nums[i], freq.get(nums[i]) + 1);
    }
    for (Integer key : freq.keySet()) {
      Integer keyFreq = freq.get(key);
      if (isPrime(keyFreq)) {
        return true;
      }
    }
    return false;
  }

  boolean isPrime(int n) {
    if (n == 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
