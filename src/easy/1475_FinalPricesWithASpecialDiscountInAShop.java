class Solution {
  public int[] finalPrices(int[] prices) {
    int[] ret = new int[prices.length];
    Stack<Integer> mst = new Stack<Integer>();
    for (int i = 0; i < ret.length; i++) {
      ret[i] = prices[i];
    }
    for (int i = 0; i < prices.length; i++) {
      int current = prices[i];
      while (!mst.isEmpty() && current <= prices[mst.peek()]) {
        int poppedIndex = mst.pop();
        ret[poppedIndex] = prices[poppedIndex] - prices[i];
      }
      mst.push(i);
    }
    return ret;
  }
}
