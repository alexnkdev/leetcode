class Solution {
  public int minGroupsWithinLimit(int[] values, int limit) {
    int n = values.length;
    int MAX = 1 << n;
    Integer[] d = new Integer[MAX];
    d[0] = 0;
   
    long[] sums = new long[MAX];
    for (int set = 0; set < MAX; set++) {
      sums[set] = 0;
      for (int k = 0; k < n; k++) {
        if ((set & (1 << k)) > 0) {
          sums[set] += values[k];
        }
      }
    }

    for (int set = 1; set < MAX; set++) {

      for (int subset = set; subset > 0; subset = (subset - 1) & set) {
        
        long sum = sums[subset];

        if (sum <= limit) {
          int restSet = set & (~subset);
          if (d[restSet] != null) {
            d[set] = d[set] == null ? (d[restSet] + 1) : Math.min(d[set], d[restSet] + 1);
            
          }
        }
      }
    }

    return d[MAX - 1];
  }
}
