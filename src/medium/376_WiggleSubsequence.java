class Solution {
  public int wiggleMaxLength(int[] a) {
    int n = a.length;
    int[][] d = new int[n][2];
    d[0][0] = 1;
    d[0][1] = 1;

    int last_increasing = 0;
    int last_decreasing = 1;

    for (int i = 0; i < n; i++) {
        d[i][last_increasing] = 1;
        d[i][last_decreasing] = 1;
        for (int prev = 0; prev < i; prev++) {

          if (a[prev] < a[i]) {
            d[i][last_increasing] = Math.max(d[i][last_increasing], d[prev][last_decreasing] + 1);
          }

          if (a[prev] > a[i]) {
            d[i][last_decreasing] = Math.max(d[i][last_decreasing], d[prev][last_increasing] + 1);
          }
        }
        
      
    }


    return Math.max(d[n - 1][last_increasing], d[n - 1][last_decreasing]);
  }
}
