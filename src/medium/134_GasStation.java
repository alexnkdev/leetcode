class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int low = 0;
    int high = 1000000000;
    int n = gas.length;
    int min_ans = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int current = 0;
      int current_fuel = mid;

      boolean possible = true;
      for (int i = 0; i < n; i++) {
        int next = i == n - 1 ? 0 : i + 1;
        current_fuel += gas[i];
        if (current_fuel < cost[i]) {
          possible = false;
          break;
        }
        current_fuel -= cost[i];
      }
      if (possible) {
        high = mid - 1;
        min_ans = mid;
      } else {
        low = mid + 1;
      }
    }
    if (min_ans == -1) {
      return -1;
    } else {
      boolean possible = false;
      int current = 0;
      int current_fuel = min_ans;
      int idx = -1;
      for (int i = 0; i < n; i++) {
        if (current_fuel <= 0) {
          idx = i;
        }
        current_fuel += gas[i];
        if (current_fuel < cost[i]) {
          possible = false;
          break;
        }
        current_fuel -= cost[i];
      }
      if (idx == -1) {
        return -1;
      }
      if (current_fuel >= min_ans) {
        return idx;
      }
      return -1;
    }
  }
}
