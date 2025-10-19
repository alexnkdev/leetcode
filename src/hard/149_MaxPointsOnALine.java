class Solution {
  public int maxPoints(int[][] points) {
    int n = points.length;
    if (n == 1) {
      return 1;
    }
    int ret = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int cnt = 2;
        for (int k = j + 1; k < n; k++) {
          if (isOnSameLine(points, i, j, k)) {
            cnt++;
          }
        }
        ret = Math.max(ret, cnt);
      }
    }
    return ret;
  }

  boolean isOnSameLine(int[][] points, int i, int j, int k) {
    double x1 = points[i][0];
    double y1 = points[i][1];
    double x2 = points[j][0];
    double y2 = points[j][1];
    double x3 = points[k][0];
    double y3 = points[k][1];

    if (eq(x2 - x1, 0)) {
      if (eq(x3 - x1, 0)) {
        return true;
      }
      return false;
    } else {
      double slope = (y2 - y1) / (x2 - x1);
      double slope2 = (y3 - y1) / (x3 - x1);
      return eq(slope, slope2);
    }
    return false;
  }

  boolean eq(double x1, double x2) {
    return Math.abs(x2 - x1) <= 0.00000001;
  }
}
