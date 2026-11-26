class Solution {
  public long countBinary101(long low, long high) {
    long without = countWithout101(high) - countWithout101(low - 1);
    long total = high - low + 1;
    return total - without;
  }

  public long countWithout101(long high) {
    String highBinary = Long.toString(high, 2);
    int N = highBinary.length();
    if (N == 0) {
      return 0;
    }
    if (high == 0) {
        return 1;
    }

    long[][][][] dp = new long[N][2][2][2];
    dp[0][0][1][1] = 1;
    dp[0][0][0][0] = 1;

    for (int i = 1; i < N; i++) {
      int bit = highBinary.charAt(i) - '0';
      for (int prevprev = 0; prevprev < 2; prevprev++) {
        for (int prev = 0; prev < 2; prev++) {
          for (int tight = 0; tight < 2; tight++) {
            
            for (int digit = 0; digit < 2; digit++) {
              if (tight == 1 && digit > bit) {
                continue;
              }
              if (prevprev == 1 && prev == 0 && digit == 1) {
                continue;
              }
              
              int newTight = 0;
              if (tight == 1 && digit == bit) {
                newTight = 1;
              }
              dp[i][prev][digit][newTight] += dp[i - 1][prevprev][prev][tight];
            
            }      
          }
        }
      }
      
    }

    long ret = 0;
    for (int prevprev = 0; prevprev < 2; prevprev++) {
      for (int prev = 0; prev < 2; prev++) {
        for (int tight = 0; tight < 2; tight++) {
          ret += dp[N - 1][prevprev][prev][tight];
        }
      }
    }
    return ret;

  }

}
