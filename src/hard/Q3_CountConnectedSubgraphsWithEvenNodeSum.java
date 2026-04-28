class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        int subsets = 1 << n;
        int ret = 0;
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            a[first][second] = true;
            a[second][first] = true;
        }
        for (int subset = 1; subset < subsets; subset++) {
            if (isGood(nums, a, subset)) {
                ret++;
            }
        }
        return ret;
    }

    boolean isGood(int[] nums, boolean[][] a, int subset) {
        int node_value_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((subset & (1 << i)) > 0) {
                node_value_sum += nums[i];
            }
        }
        if (node_value_sum % 2 != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];

        int start = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if ((subset & (1 << i)) > 0) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return false;
        }

        Queue<Integer> qq = new LinkedList<Integer>();
        qq.add(start);
        while (!qq.isEmpty()) {
            int current = qq.poll();
            visited[current] = true;
            for (int i = 0; i < nums.length; i++) {
                if ((subset & (1 << i)) > 0) {
                    if (i != current && a[current][i] && !visited[i]) {
                        qq.add(i);
                        visited[i] = true;
                    }
                }
            }
        }

        boolean connected = true;
        for (int i = 0; i < nums.length; i++) {
            if ((subset & (1 << i)) > 0) {
                if (!visited[i]) {
                    connected = false;
                    break;
                }
            }
        }

        return connected;
    }
    
}
