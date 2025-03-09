class Solution {
    public int minReorder(int n, int[][] connections) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        List<Integer>[] outgoing_edges = new List[n];
        List<Integer>[] incoming_edges = new List[n];
        for (int i = 0; i < n; i++) {
            outgoing_edges[i] = new ArrayList<>();
            incoming_edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];
            outgoing_edges[from].add(to);
            incoming_edges[to].add(from);
        }
        int ret = 0;
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            Integer current = q.poll();
            visited[current] = true;
            for (int i = 0; i < outgoing_edges[current].size(); i++) {
                int to = outgoing_edges[current].get(i);
                if (!visited[to]) {
                    ret++;
                    q.add(to);
                }
            }
            for (int i = 0; i < incoming_edges[current].size(); i++) {
                int from = incoming_edges[current].get(i);
                if (!visited[from]) {
                    q.add(from);
                }
            }
        }
        return ret;
    }
}