class Solution {
  public int minPickupsToReach(int target, int initialUnits, int[][] supplies) {
  
    int currentSupplies = initialUnits;
    int pos = 0;
    int ret = 0;
    PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2) -> {
      return -Integer.compare(i1, i2);
    });
    for (int i = 0; i <= supplies.length; i++) {
      int next = i < supplies.length ? supplies[i][0] : target;
      int dist = next - pos;
      if (dist > currentSupplies) {
        while (!q.isEmpty() && currentSupplies < dist) {
          int refuel = q.poll();
          currentSupplies += refuel;
          ret++;
        }
        if (currentSupplies < dist) {
          return -1;
        }
        pos = next;
        currentSupplies -= dist;
      }
      if (i < supplies.length) {
        q.add(supplies[i][1]);
      }
    }

    return ret;
  }
}
