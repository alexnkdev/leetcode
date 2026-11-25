class Solution {
  public long cheapestPathWithFreeNode(int n, int[][] edges, int[] cost, int start, int target) {

    Map<Integer, List<Edge>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      adj.get(u).add(new Edge(u, v, cost[v]));
      adj.get(v).add(new Edge(v, u, cost[u]));
    }

    PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> {
      return Long.compare(n1.dist, n2.dist);
    });

    int startNode = n;
    n++;

    adj.put(startNode, new ArrayList<>());
    adj.get(startNode).add(new Edge(startNode, start, 0));

    pq.add(new Node(startNode, 0, 0, 0));

    boolean[][][] visited = new boolean[n][2][2];
    Long[][][] d = new Long[n][2][2];

    d[startNode][0][0] = 0L;

    while (!pq.isEmpty()) {

      Node current = pq.poll();
      if (visited[current.i][current.freeUsed][current.freeNode]) {
        continue;
      }

      visited[current.i][current.freeUsed][current.freeNode] = true;


      for (Edge edge : adj.get(current.i)) {
        
        if (current.freeUsed == 0) {
          
          long edgeWeight = 0L;
          long newDist = d[current.i][current.freeUsed][current.freeNode] + edgeWeight;
          Node newNodeFree = new Node(edge.v, 1, 1, newDist);
          if (!visited[newNodeFree.i][newNodeFree.freeUsed][newNodeFree.freeNode] 
          && (d[edge.v][1][1] == null || newDist < d[edge.v][1][1])) {
            d[edge.v][1][1] = newDist;
            pq.add(newNodeFree);
          }
        
        }
        
        int edgeWeight = cost[edge.v];
        if (current.freeNode == 1) {
          edgeWeight = 2 * cost[edge.v];
        }

        long newDist = d[current.i][current.freeUsed][current.freeNode] + edgeWeight;
        Node otherNode = new Node(edge.v, current.freeUsed, 0, newDist);

        if (!visited[otherNode.i][otherNode.freeUsed][otherNode.freeNode]
         && (d[edge.v][otherNode.freeUsed][otherNode.freeNode] == null || newDist < d[edge.v][otherNode.freeUsed][otherNode.freeNode])) {
          d[edge.v][otherNode.freeUsed][otherNode.freeNode] = newDist;
          pq.add(otherNode);
        }

      }

    }

    Long min = null;
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            if (d[target][i][j] != null) {
                min = min == null ? d[target][i][j] : Math.min(min, d[target][i][j]);
            }
        }
    }
    return min == null ? -1 : min;




  }

  class Node {
    int i;
    int freeUsed;
    int freeNode;
    long dist;
    public Node(int i, int freeUsed, int freeNode, long dist) {
        this.i = i;
        this.freeUsed = freeUsed;
        this.freeNode = freeNode;
        this.dist = dist;
    }

    public String toString() {
        return "[" + i + ", " + freeUsed + ", " + freeNode + "]";
    }
  }

  class Edge {
    int u, v, cost;
    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
  }

}
