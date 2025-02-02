class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (!isRowValid(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (!isColValid(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isSubSquareValid(board, i * 3, j * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isRowValid(char[][] board, int row) {
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] != '.') {
                if (used.contains(board[row][i])) {
                    return false;
                }
                used.add(board[row][i]);
            }
        }
        return true;
    }

    boolean isColValid(char[][] board, int col) {
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.') {
                if (used.contains(board[i][col])) {
                    return false;
                }
                used.add(board[i][col]);
            }
        }
        return true;
    }

    boolean isSubSquareValid(char[][] board, int startRow, int startCol) {
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] != '.') {
                    if (used.contains(board[startRow + i][startCol + j])) {
                        return false;
                    }
                    used.add(board[startRow + i][startCol + j]);
                }
            }
        }
        return true;
    }
}