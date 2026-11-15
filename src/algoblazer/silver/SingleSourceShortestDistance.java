class Solution {

  public int[] shortestDistances(int n, int[][] edges) {
    
    Map<Integer, Set<Integer>> adj = new HashMap<>();

    Integer[][] cost = new Integer[n][n];

    for (int i = 0; i < n; i++) {
      adj.put(i, new HashSet<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0] - 1;
      int b = edges[i][1] - 1;
      int c = edges[i][2];
      
      Set<Integer> aAdj = adj.getOrDefault(a, new HashSet<>());
      aAdj.add(b);

      adj.put(a, aAdj);

      cost[a][b] = cost[a][b] == null ? c : Math.min(cost[a][b], c);

    }

    Integer[] d = new Integer[n];
    d[0] = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
        (v1, v2) -> {
          return Integer.compare(d[v1], d[v2]);
        }
        );
    pq.add(0);

    boolean[] visited = new boolean[n];

    while (!pq.isEmpty()) {
      Integer currentVertex = pq.poll();
      visited[currentVertex] = true;
      for (Integer other : adj.get(currentVertex)) {
        if (!visited[other]) {

          if (d[other] == null || d[other] > d[currentVertex] + cost[currentVertex][other]) {
            d[other] = d[currentVertex] + cost[currentVertex][other];
            pq.remove(other);
            pq.add(other);
          }
        }
      }
    }

    int[] ret = new int[n];
    for (int i = 0; i < n; i++) {
      ret[i] = d[i];
    }

    return ret;
  }

}
