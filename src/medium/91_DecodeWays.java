class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int sum = 0;
            for (int k = 1; k <= 26; k++) {
                String sub = "" + k;
                if (sub.length() == 1) {
                    if (s.charAt(i - 1) == sub.charAt(0)) {
                        sum += dp[i - 1];
                    }
                } else {
                    if (i > 1 && s.charAt(i - 1) == sub.charAt(1) && s.charAt(i - 2) == sub.charAt(0)) {
                        sum += dp[i - 2];
                    }
                }
            }
            dp[i] = sum;
        }
        return dp[s.length()];
    }
}