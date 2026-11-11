class Solution {
    public int propagationTime(int[][] grid) {
        Queue<Pos> q = new LinkedList<>();
        int[][] time = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pos(i, j));
                    time[i][j] = 0;
                }
            }
        }
        int[] di = new int[] { 0, 0, 1, -1 };
        int[] dj = new int[] { 1, -1, 0, 0 };
        while (!q.isEmpty()) {
            Pos current = q.poll();
            for (int k = 0; k < di.length; k++) {
                int ni = current.i + di[k];
                int nj = current.j + dj[k];
                if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length) {
                    if (grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        time[ni][nj] = time[current.i][current.j] + 1;
                        q.add(new Pos(ni, nj));
                    }
                }
            }
        }
        int maxTime = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                if (grid[i][j] == 2) {
                    maxTime = Math.max(maxTime, time[i][j]);
                }
            }
        }
        return maxTime;
    }

    class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
