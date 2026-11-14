class Solution {

  boolean[] visited;

  public int minNewEdges(int n, int[][] edges) {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0] - 1;
      int b = edges[i][1] - 1;
      
      Set<Integer> aAdj = adj.getOrDefault(a, new HashSet<>());
      aAdj.add(b);
      adj.put(a, aAdj);

      Set<Integer> bAdj = adj.getOrDefault(b, new HashSet<>());
      bAdj.add(a);
      adj.put(b, bAdj);
    }

    visited = new boolean[n];

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        cnt++;
        dfs(i, adj);
      }
    }
    return cnt - 1;
  }

  void dfs(int current, Map<Integer, Set<Integer>> adj) {
    visited[current] = true;
    if (adj.get(current) == null) {
      return;
    }
    for (Integer other : adj.get(current)) {
      if (!visited[other]) {
        dfs(other, adj);
      }
    }
  }
}
