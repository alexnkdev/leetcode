import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int[] di = new int[] { 0, 0, 1, -1 };
        int[] dj = new int[] { 1, -1, 0, 0 };
        Integer[][] heights = new Integer[n][m];
        Queue<Cell> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.add(new Cell(i, j));
                    heights[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Cell current = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = current.i + di[k];
                int nj = current.j + dj[k];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && heights[ni][nj] == null) {
                    heights[ni][nj] = heights[current.i][current.j] + 1;
                    q.add(new Cell(ni, nj));
                }
            }
        }
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = heights[i][j];
            }
        }
        return ret;
    }

    static class Cell {
        int i, j;
        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}