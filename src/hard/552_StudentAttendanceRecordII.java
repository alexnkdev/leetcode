class Solution {
  public int checkRecord(int n) {
    int MOD = 1000000000 + 7;
    long[][][] d = new long[n + 1][2][3];
    d[0][0][0] = 1L;

    for (int i = 1; i <= n; i++) {
      for (int absenses = 0; absenses < 2; absenses++) {
        for (int lateInARow = 0; lateInARow < 3; lateInARow++) {
          
          // 'A' 
          // _ _ _ _ A 
          if (absenses > 0 && lateInARow == 0) {
            d[i][absenses][0] =
              (
               + d[i - 1][absenses - 1][0]
               + d[i - 1][absenses - 1][1]
               + d[i - 1][absenses - 1][2]) % MOD;
          }

        //   // 'L'
        //   // _ _ _ _ L
          if (lateInARow > 0) {
            d[i][absenses][lateInARow] = (d[i][absenses][lateInARow] + d[i - 1][absenses][lateInARow - 1]) % MOD;

          }

        //   // 'P'
        //   // _ _ _ _ P

        // 0 0 3

        if (lateInARow == 0) {
          d[i][absenses][0] = 
            (
                d[i][absenses][0] + 
             + d[i - 1][absenses][2]
             + d[i - 1][absenses][1]
             + d[i - 1][absenses][0]) % MOD;
        }

        }
      }
    }

    long ret = 0;
    for (int absenses = 0; absenses < 2; absenses++) {
      for (int late = 0; late < 3; late++) {
        ret = (ret + d[n][absenses][late]) % MOD;
      }
    }
    
    return (int) ret;
  }
}
