class Solution {
  public boolean canCompleteAllTasks(int n, int[][] req) {
  
    boolean[] visited = new boolean[n];
    boolean[] current = new boolean[n];
  
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
        adj.put(i, new ArrayList<>());
    }
    for (int i = 0; i < req.length; i++) {
        int a = req[i][0];
        int b = req[i][1];
        adj.get(a).add(b);
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (dfs(i, current, visited, adj)) {
          return false;
        }
      }
    }

    return true;
  }

  boolean dfs(int k, boolean[] current, boolean[] visited, Map<Integer, List<Integer>> adj) {
    
    if (current[k]) {
      return true;
    }

    if (visited[k]) {
      return false;
    }

    visited[k] = true;
    current[k] = true;

    for (int u : adj.get(k)) {
      if (dfs(u, current, visited, adj)) {
        return true;
      }
    }

    current[k] = false;

    return false;

  }

}
