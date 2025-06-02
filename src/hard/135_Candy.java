class Solution {

  static boolean[] visited;
  static int[] longestPath;

  public int candy(int[] ratings) {
    int n = ratings.length;
    visited = new boolean[n];
    longestPath = new int[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        calc(ratings, i);
      }
    }
    int ret = 0;
    for (int i = 0; i < n; i++) {
      ret += longestPath[i];
    }
    return ret;
  }

  static int calc(int[] ratings, int k) {
    if (visited[k]) {
      return longestPath[k];
    }
    visited[k] = true;
    int ret = 1;
    if (k > 0 && ratings[k - 1] < ratings[k]) {
      ret = Math.max(ret, calc(ratings, k - 1) + 1);
    }
    if (k < ratings.length - 1 && ratings[k + 1] < ratings[k]) {
      ret = Math.max(ret, calc(ratings, k + 1) + 1);
    }
    longestPath[k] = ret;
    return ret;
  }

}
