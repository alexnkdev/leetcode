class Solution {
  public int[] kRowsWithFewestOnes(int[][] mat, int k) {
    int[] ones = new int[mat.length];
    for (int i = 0; i < mat.length; i++) {
      ones[i] = 0;
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1) {
          ones[i]++;
        }
      }
    }

    int[] idx = new int[mat.length];
    for (int i = 0; i < idx.length; i++) {
      idx[i] = i;
    }

    Arrays.sort(idx, (idx1, idx2) -> {
      if (ones[idx1] != ones[idx2])) {
        return Integer.compare(ones[idx1], ones[idx2]);
      } else {
        return Integer.compare(idx1, idx2);
      }
    });

    return idx;
  }
}
