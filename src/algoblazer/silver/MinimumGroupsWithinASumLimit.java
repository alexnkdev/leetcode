class Solution {
  public int minGroupsWithinLimit(int[] values, int limit) {
    int n = values.length;
    int[][] possible = new int[n + 1][1 << n];

    possible[0][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int used_set = 0; used_set < (1 << n); used_set++) {

        for (int take_set = ; j < n; j++) {
          
        }

      }
    }


    return possible[n][(1 << n) - 1];
  }
}
