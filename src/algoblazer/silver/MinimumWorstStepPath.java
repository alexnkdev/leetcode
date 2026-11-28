class Solution {
    int[] di = new int[] { 0, 0, 1, -1 };
    int[] dj = new int[] { 1, -1, 0, 0 };

    public int minimumWorstStepPath(int[][] grid) {
        int low = 0;
        int high = 1000_000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (possible(grid, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean possible(int[][] grid, int maxDiff) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Square> q = new LinkedList<>();
        q.add(new Square(0, 0));
        while (!q.isEmpty()) {
            Square current = q.poll();
            visited[current.i][current.j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = current.i + di[k];
                int nj = current.j + dj[k];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m) {
                    if (!visited[ni][nj]) {
                        int diff = Math.abs(grid[ni][nj] - grid[current.i][current.j]);
                        if (diff <= maxDiff) {
                            visited[ni][nj] = true;
                            q.add(new Square(ni, nj));
                        }
                    }
                }
            }
        }   
        return visited[n - 1][m - 1];     
    }

    record Square(int i, int j) {};
}
