
class Solution {

  public int[] shortestDistances(int n, int[][] edges) {
    
    Map<Integer, List<Edge>> adj = new HashMap<>();

    for (int i = 0; i < n; i++) {
      adj.put(i, new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0] - 1;
      int b = edges[i][1] - 1;
      int c = edges[i][2];
      
      List<Edge> aAdj = adj.getOrDefault(a, new ArrayList<>());
      adj.put(a, aAdj);

      boolean found = false;
      for (Edge existing : aAdj) {
        if (existing.u == b) {
            existing.w = Math.min(existing.w, c);
            found = true;
        }
      }

      if (!found) {
        aAdj.add(new Edge(b, c));
      }

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
      for (Edge edge : adj.get(currentVertex)) {
        int other = edge.u;
        if (!visited[other]) {

          if (d[other] == null || d[other] > d[currentVertex] + edge.w) {
            d[other] = d[currentVertex] + edge.w;
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

  class Edge {
    int u;
    int w;
    public Edge(int u, int w) {
        this.u = u;
        this.w = w;
    }
  }

}
