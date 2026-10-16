class Solution {

  public int countVowelPermutation(int n) {
    
    int numVowels = 5;
    int MOD = 1000000000 + 7;

    long[][] dp = new long[n + 1][numVowels];
    String vowels = "aeiou";
    for (int last = 0; last < vowels.length(); last++) {
      dp[1][last] = 1L;
    }

    for (int i = 2; i <= n; i++) {
      for (int last = 0; last < vowels.length(); last++) {
        for (int prev = 0; prev < vowels.length(); prev++) {
          char lastCh = vowels.charAt(last);
          char prevCh = vowels.charAt(prev);
          if (ok(prevCh, lastCh)) {
            dp[i][last] = (dp[i][last] + dp[i - 1][prev]) % MOD;
          }
        }      
      }
    }

    long ret = 0;
    for (int last = 0; last < vowels.length(); last++) {
      ret = (ret + dp[n][last]) % MOD;
    }

    return (int) ret;

  }

  boolean ok(char prev, char next) {
    if (prev == 'a') {
      return next == 'e';
    }
    if (prev == 'e') {
      return next == 'a' || next == 'i';
    }
    if (prev == 'i') {
      return next != 'i';
    }
    if (prev == 'o') {
      return next == 'i' || next == 'u';
    }
    if (prev == 'u') {
      return next == 'a';
    }
    return false;
  }

}
