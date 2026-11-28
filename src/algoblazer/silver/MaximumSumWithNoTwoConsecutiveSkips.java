class Solution {
    public long maxSumNoTwoConsecutiveSkips(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        int skipped = 0;
        int not_skipped = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            dp[i][skipped] = dp[i - 1][not_skipped];
            dp[i][not_skipped] =
                num + Math.max(dp[i - 1][skipped], dp[i - 1][not_skipped]);
        }
        return Math.max(dp[n][skipped], dp[n][not_skipped]);
    }
}
