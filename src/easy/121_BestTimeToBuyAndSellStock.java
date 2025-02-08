class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        Integer min = null;
        for (int i = 0; i < prices.length; i++) {
            if (min == null || prices[i] < min) {
                min = prices[i];
            }
            ret = Math.max(ret, prices[i] - min);
        }
        return ret;
    }
}