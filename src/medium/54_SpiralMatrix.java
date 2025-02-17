class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = 0;
        int d = 0;
        int[] di = { 0, 1, 0, -1 };
        int[] dj = { 1, 0, -1, 0 };
        List<Integer> ret = new ArrayList<>();
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        while (cnt < n * m) {
            ret.add(matrix[i][j]);
            visited[i][j] = true;
            cnt++;
            if (cnt == n * m) {
                break;
            }
            while (true) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m
                && !visited[ni][nj]) {
                    i = ni;
                    j = nj;
                    break;
                } else {
                    d = (d + 1) % di.length;
                }
            }
        }
        return ret;
    }
}