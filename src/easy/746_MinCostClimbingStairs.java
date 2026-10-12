class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] minCost = new int[n + 1];
    minCost[0] = 0;
    minCost[1] = 0;
    for (int step = 2; step <= n; step++) {
      minCost[step] = Math.min(minCost[step - 1] + cost[step - 1], minCost[step - 2] + cost[step - 2]);
    }
    return minCost[n];
  }
}
