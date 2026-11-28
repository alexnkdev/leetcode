class Solution {

    Map<Integer, Integer> depths = new HashMap<>();

    public int treeDiameter(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0] - 1).add(edges[i][1] - 1);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int max1 = 0, max2 = 0;
            for (Integer child : adj.get(i)) {
                int dd = maxDepth(child, adj);
                if (dd > max1) {
                    max2 = max1;
                    max1 = dd;
                } else if (dd > max2) {
                    max2 = dd;
                }
            }
            ret = Math.max(ret, max1 + max2 + 1);
        }
        return ret - 1;
    }

    int maxDepth(int node, Map<Integer, List<Integer>> adj) {
        if (depths.containsKey(node)) {
            return depths.get(node);
        }
        int ret = 1;
        for (Integer other : adj.get(node)) {
            ret = Math.max(ret, maxDepth(other, adj) + 1);
        }
        depths.put(node, ret);
        return ret;
    }
}
