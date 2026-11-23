class Solution {
  public int[] scoreToken(int t, int[][] embedding, int[][] linear, int[][] outputEmbedding) {
    int v = outputEmbedding.length;
    int d = embedding[0].length;

    int[] a = new int[d];
    for (int i = 0; i < d; i++) {
      a[i] = embedding[t][i];
    }

    int[] b = new int[d];
    for (int j = 0; j < d; j++) {

      for (int i = 0; i < d; i++) {
        b[j] += linear[j][i] * a[i];
      }
    }


    int[] c = new int[d];
    for (int i = 0; i < d; i++) {
      c[i] = b[i] > 0 ? b[i] : 0;
    }

    int[] s = new int[v];
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < d; j++) {
        s[i] += outputEmbedding[i][j] * c[j];
      }
    }
    return s;
  }
}
