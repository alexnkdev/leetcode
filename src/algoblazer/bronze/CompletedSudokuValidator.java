class Solution {
  public boolean isValidSudoku(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      if (!isValidRow(matrix, i)) {
        return false;
      }
    }

    for (int i = 0; i < matrix[0].length; i++) {
      if (!isValidColumn(matrix, j)) {
        return false;
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int boxI = i * 3;
        int boxJ = j * 3;
        if (!isValidBox(matrix, boxI, boxJ)) {
          return false;
        }
      }
    }

    return true;
  }

  boolean isValidRow(int[][] m, int row) {
    Set<Integer> digits = new HashSet<>();
    for (int i = 0; i < m[0].length; i++) {
      digits.add(m[row][i]);
    }
    return digits.size() == 9;
  }

  boolean isValidColumn(int[][] m, int col) {
    Set<Integer> digits = new HashSet<>();
    for (int i = 0; i < m.length; i++) {
      digits.add(m[i][col]);
    }
    return digits.size() == 9;
  }

  boolean isValidBox(int[][] m, int boxI, int boxJ) {
    Set<Integer> digits = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int ni = boxI + i;
        int nj = boxJ + j;
        digits.add(m[ni][nj]);
      }
    }
    return digits.size() == 9;
  }
}
