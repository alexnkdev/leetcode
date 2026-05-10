pclass Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ret = new int[amount + 1];
        ret[0] = 0;
        for (int i = 1; i <= amount; i++) {
            ret[i] = -1;
            for (int k = 0; k < coins.length; k++) {
                if (i - coins[k] >= 0 && ret[i - coins[k]] != -1) {
                    ret[i] = ret[i] == -1 ? (ret[i - coins[k]] + 1) : Math.min(ret[i], ret[i - coins[k]] + 1);
                }
            }
        }
        return ret[amount];
    }
}
