class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] match = new boolean[n + 1][m + 1];
        match[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean ok = false;
                if (i - 1 >= 0 && p.charAt(j - 1) == '.') {
                    ok |= match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    char prev = p.charAt(j - 2);
                    ok |= match[i][j - 2];
                    int k = i - 1;
                    if (prev == '.') {
                        while (k >= 0 ) {
                            ok |= match[k][j - 2];
                            k--;
                        }
                    } else {
                        while (k >= 0 && s.charAt(k) == prev) {
                            ok |= match[k][j - 2];
                            k--;
                        }
                    }
                } else {
                    if (i - 1 >= 0 && s.charAt(i - 1) == p.charAt(j - 1)) {
                        ok |= match[i - 1][j - 1];
                    }
                }
                match[i][j] = ok;
            }
        }
        return match[n][m];
    }
}