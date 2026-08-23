class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long ret = 0;
        for (int i = 0; i < k; i++) {
            long maxAlloys = calc(i, n, budget, composition, stock, cost);
            ret = Math.max(ret, maxAlloys);
        }
        return (int) ret;
    }

    long calc(int machineIdx, int metals, int budget, List<List<Integer>> comp, List<Integer> stock, List<Integer> cost) {
        long budgetLeft = budget;
        long costNeeded = 0;
        long low = 0;
        long high = 1000000000;
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canMakeNAlloys(machineIdx, mid, metals, budget, comp, stock, cost)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    boolean canMakeNAlloys(int machineIdx, long numAlloys, long metals, long budget, List<List<Integer>> comp, List<Integer> stock, List<Integer> cost) {
        int[] metalInStock = new int[stock.size()];
        for (int i = 0; i < stock.size(); i++) {
            metalInStock[i] = stock.get(i);
        }
        long costUsed = 0;
        for (int metal = 0; metal < metals; metal++) {
            long metalNeeded = numAlloys * comp.get(machineIdx).get(metal);
            long metalFromStock = Math.min(metalNeeded, metalInStock[metal]);
            metalInStock[metal] -= metalFromStock;
            metalNeeded -= metalFromStock;
            costUsed += metalNeeded * cost.get(metal);
        }
        if (costUsed <= budget) {
            return true;
        }
        return false;
    }
}
