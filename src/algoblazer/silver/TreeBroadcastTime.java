class Solution {
  public int broadcastTime(int n, int root, int[] parent, int[] delay) {
    Map<Integer, List<Integer>> children = new HashMap<>();
    for (int i = 0; i < n; i++) {
      children.put(i, new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      if (parent[i] != -1) {
        children.get(parent[i]).add(i);
      }
    }
    return rec(root, children, delay, 0);
  }

  int rec(int root, Map<Integer, List<Integer>> children, int[] delay, int time) {
    
    int ret = time;

    for (int i = 0; i < children.get(root).size(); i++) {
      int other = children.get(root).get(i);
      ret = Math.max(ret, rec(other, children, delay, time + delay[root]));
    }

    return ret;
  }

}
