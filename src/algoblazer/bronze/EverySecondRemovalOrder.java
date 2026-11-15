class Solution {
  public int[] removalOrder(int n) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      q.add(i);
    }

    int step = 0;
    List<Integer> ret = new ArrayList<>();
    while (!q.isEmpty()) {
      int next = q.poll();
      if (step % 2 == 0) {
        q.add(next);
      } else {
        ret.add(next);
      }
      step++;
    }
    int[] ret_arr = new int[ret.size()];
    for (int i = 0; i < ret.size(); i++) {
      ret_arr[i] = ret.get(i);
    }
    return ret_arr;
  }
}
