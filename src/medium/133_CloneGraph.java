class Solution {

  private Map<Integer, Node> clonedNodes;

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    clonedNodes = new HashMap<>();
    Node cloned = dfs(node);
    return cloned;
  }

  Node dfs(Node originalNode) {
    Node cloned = new Node();
    cloned.val = originalNode.val;
    clonedNodes.put(originalNode.val, cloned);
    for (Node neighbor : originalNode.neighbors) {
      Node clonedNeighbor = clonedNodes.get(neighbor.val);
      if (clonedNeighbor != null) {
        cloned.neighbors.add(clonedNeighbor);
      } else {
        clonedNeighbor = dfs(neighbor);
        cloned.neighbors.add(clonedNeighbor);
      }
    }
    return cloned;
  }
}
