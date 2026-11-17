class Solution {

  public boolean isMatch(String s, String pattern) {
    
    int n = s.length();
    int m = pattern.length();
    boolean[][] ok = new boolean[n + 1][m + 1];
    ok[0][0] = true;

    for (int i = 0; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (i - 1 >= 0 && pattern.charAt(j - 1) == '.') {
          ok[i][j] = ok[i - 1][j - 1];
        } else if (pattern.charAt(j - 1) == '*') {
          char before = pattern.charAt(j - 2);
          ok[i][j] = ok[i][j - 2];
          for (int take_chars = 0; take_chars < i; take_chars++) {
            if (s.charAt(i - 1 - take_chars) == before || before == '.') {
              ok[i][j] |= ok[i - 1 - take_chars][j - 2];
            } else {
              break;
            }
          }
        } else {
          if (i - 1 >= 0 ) {
            if (s.charAt(i - 1) == pattern.charAt(j - 1)) {
              ok[i][j] = ok[i - 1][j - 1];
            }
          }
        }


      }
    }

    return ok[n][m];

  }

}
