class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Character[][] map = new Character[numRows][s.length()];
        int curRow = 0;
        int curCol = 0;
        boolean movingDown = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[curRow][curCol] = c;
            if (movingDown) {
                if (curRow == numRows - 1) {
                    movingDown = false;
                    curRow--;
                    curCol++;
                } else {
                    curRow++;
                }
            } else {
                if (curRow == 0) {
                    movingDown = true;
                    curRow++;
                } else {
                    curRow--;
                    curCol++;
                }
            }
        }
        String ret = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (map[i][j] != null) {
                    ret += map[i][j];
                }
            }
        }
        return ret;
    }
}