class Solution {

    static int[] di = new int[] { 0, 0, 1, -1 };
    static int[] dj = new int[] { 1, -1, 0, 0 };
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (canMakeWord(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean canMakeWord(char[][] board, int i, int j, int k, String word, boolean[][] visited) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int t = 0; t < 4; t++) {
            int ni = i + di[t];
            int nj = j + dj[t];
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                if (!visited[ni][nj] && canMakeWord(board, ni, nj, k + 1, word, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}