class Solution {
  public int longestSubsequence(String s, int k) {
    int ans = 0;
    for (int numOnes = 0; numOnes <= s.length(); numOnes++) {
      int len = 0;
      int tookOnes = 0;
      long val = 0L;
      for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '1') {
          if (tookOnes < numOnes) {
            if (len > 30) {
              continue;
            }
            long pwr = 1 << len;
            val = pwr + val;
            if (val > k) {
              continue;
            }
            len++;
            tookOnes++;
          }
        } else {
          len++;
        }
      }
      ans = Math.max(ans, len);
    }
    return ans;
  }
}
