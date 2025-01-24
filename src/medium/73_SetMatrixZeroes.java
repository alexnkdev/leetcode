class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int mark = 0;
        while (true) {
            boolean good = true;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == mark) {
                        good = false;
                        break;
                    }
                }
                if (!good) {
                    break;
                }
            }
            if (!good) {
                mark++;
            } else {
                break;
            }
        }
        for (int r = 0; r < rows; r++) {
            boolean hasZero = false;
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (hasZero) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] != 0) {
                        matrix[r][c] = mark;
                    }
                }
            }
        }
        for (int c = 0; c < cols; c++) {
            boolean hasZero = false;
            for (int r = 0; r < rows; r++) {
                if (matrix[r][c] == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (hasZero) {
                for (int r = 0; r < rows; r++) {
                    if (matrix[r][c] != 0) {
                        matrix[r][c] = mark;
                    }
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == mark) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}