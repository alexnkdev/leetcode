class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
    boolean[] visited = new boolean[n];
    int[] d = new int[n];
    d[k - 1] = 0;
    for (int i = 0; i < n; i++) {
      if (i != k - 1) {
        d[i] = -1;
      }
    }
    int next_node = k - 1;
    visited[k - 1] = true;
    while (true) {
      int current = next_node;
      visited[current] = true;
      for (int i = 0; i < times.length; i++) {
        if (times[i][0] - 1 == current) {
          int other = times[i][1] - 1;
          if (visited[other]) {
            continue;
          }
          int weight = times[i][2];
          d[other] = d[other] == -1 ? (d[current] + weight)
              : Math.min(d[other], d[current] + weight);
        }
      }
      next_node = -1;
      int best = -1;
      for (int i = 0; i < n; i++) {
        if (d[i] >= 0 && !visited[i]) {
          if (best == -1 || best > d[i]) {
            best = d[i];
            next_node = i;
          }
        }
      }
      if (next_node == -1) {
        break;
      }
    }
    int ret = -1;
    for (int i = 0; i < n; i++) {
      if (d[i] == -1) {
        return -1;
      }
      ret = ret == -1 ? d[i] : Math.max(d[i], ret);
    }
    return ret;
  }
}
