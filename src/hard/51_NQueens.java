class Solution {

    Character[][] map;
    boolean[] used;

    boolean[] used_diag_1;
    boolean[] used_diag_2;

    public List<List<String>> solveNQueens(int n) {
        map = new Character[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        used = new boolean[n];
        used_diag_1 = new boolean[2 * n];
        used_diag_2 = new boolean[2 * n];
        return rec(0, n);
    }

    List<List<String>> rec(int i, int n) {
        if (i == n) {
            List<String> position = new ArrayList<>();
            for (int k1 = 0; k1 < n; k1++) {
                String str = "";
                for (int k2 = 0; k2 < n; k2++) {
                    str += map[k1][k2];
                }
                position.add(str);
            }
            return List.of(position);
        } else {
            int sum = 0;
            List<List<String>> ret = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int diag1 = i + j;
                int diag2 = i - j + n;
                if (!used[j] && !used_diag_1[diag1]
                && !used_diag_2[diag2]) {
                    used[j] = true;
                    used_diag_1[diag1] = true;
                    used_diag_2[diag2] = true;
                    map[i][j] = 'Q';
                    ret.addAll(rec(i + 1, n));
                    map[i][j] = '.';
                    used[j] = false;
                    used_diag_1[diag1] = false;
                    used_diag_2[diag2] = false;
                }
            }
            return ret;
        }
    }

}