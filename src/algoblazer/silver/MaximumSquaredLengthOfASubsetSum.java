class Solution {
  public int maxSquaredVectorLength(int[][] vecs) {
    int n = vecs.length;
    int ret = 0;
    for (int set = 0; set < (1 << n); set++) {
      int sum = 0;
      int[] newVec = new int[vecs[0].length];
      for (int i = 0; i < n; i++) {
        if ((set & (1 << i)) > 0) {
          for (int j = 0; j < vecs[i].length; j++) {
            newVec[j] += vecs[i][j];
          } 
        }
      }
      ret = Math.max(ret, sumVector(newVec));
    }
    return ret;
  }

  int sumVector(int[] v) {
    int ret = 0;
    for (int i = 0; i < v.length; i++) {
      ret += v[i] * v[i];
    }
    return ret;
  }
}
