class Solution {
  
  int[] colors;
  boolean[] visited;

  int white = 0;
  int black = 1;

  public boolean isTwoColorable(int[][] g) {
    colors = new int[g.length];
    visited = new boolean[g.length];
    for (int i = 0; i < g.length; i++) {
      if (!visited[i]) {
        if (!isTwoColorable(g, i, white)) {
          return false;
        }
      }
    }
    return true;
  }

  boolean isTwoColorable(int[][] g, int current, int color) {
    colors[current] = color;
    visited[current] = true;
    for (int i = 0; i < g[current].length; i++) {
      int other = g[current][i];
      if (!visited[other]) {
        boolean sub = isTwoColorable(g, other, 1 - color);
        if (!sub) {
          return false;
        }
      } else {
        if (colors[other] == color) {
          return false;
        }
      }
    }
    return true;
  }
}
