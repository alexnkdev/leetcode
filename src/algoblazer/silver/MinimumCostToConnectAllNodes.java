class Solution {
  public long minConnectionCost(int n, int[][] edges) {
    Map<Integer, List<Edge>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0] - 1;
      int b = edges[i][1] - 1;
      long c = edges[i][2];
      adj.get(a).add(new Edge(a, b, c));
      adj.get(b).add(new Edge(b, a, c));
    }

    long[] d = new long[n];
    PriorityQueue<Node> pq = new PriorityQueue<Node>((v1, v2) -> {
      return Long.compare(v1.cost, v2.cost);
    });

    int start = 0;
    d[start] = 0;
    for (int i = 1; i < n; i++) {
      d[i] = -1;
    }
    
    boolean[] visited = new boolean[n];
    pq.add(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node current = pq.poll();

      if (visited[current.u]) {
        continue;
      }

      visited[current.u] = true;

      for (Edge edge : adj.get(current.u)) {
        int other = edge.v;
        if (!visited[other] && (d[other] == -1 || edge.w < d[other])) {
          d[other] = edge.w;
          pq.add(new Node(other, d[other]));
        }
      }
    }

    long ret = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        return -1;
      }
      ret += d[i];
    }
    return ret;
  }

  class Node {
    int u;
    long cost;
    public Node(int u, long cost) {
      this.u = u;
      this.cost = cost;
    }
  }

  class Edge {
    int u, v;
    long w;
    public Edge(int u, int v, long w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }
}
