class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int k = 1; k <= n; k++) {
            boolean ok = false;
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (k - word.length() >= 0 && dp[k - word.length()]) {
                    String sub = s.substring(k - word.length(), k);
                    if (sub.equals(word)) {
                        ok = true;
                        break;
                    }
                }
            }
            dp[k] = ok;
        }
        return dp[n];
    }
}
