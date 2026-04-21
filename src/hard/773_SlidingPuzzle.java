class Solution {
    public int slidingPuzzle(int[][] board) {

        Queue<Pos> q = new LinkedList<>();
        Map<Pos, Integer> minDistance = new HashMap<>();
        Pos startingPos = new Pos(board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2]);
        q.add(startingPos);
        minDistance.put(startingPos, 0);

        while (!q.isEmpty()) {
            Pos current = q.poll();
            int cur = minDistance.get(current);
            List<Pos> adjacent = doSwaps(current);

            for (Pos adj : adjacent) {
                if (!minDistance.containsKey(adj)) {
                    minDistance.put(adj, cur + 1);
                    q.add(adj);
                }
            }

        }

        Pos finalState = new Pos(1, 2, 3, 4, 5, 0);

        return minDistance.containsKey(finalState) ? minDistance.get(finalState) : -1;

    }

    List<Pos> doSwaps(Pos pos) {
        int zeroI = 0;
        int zeroJ = 0;
        int[][] board = new int[2][3];
        board[0] = new int[] { pos.a, pos.b, pos.c };
        board[1] = new int[] { pos.d, pos.e, pos.f };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zeroI = i;
                    zeroJ = j;
                    break;
                }
            }
        }

        int[] di = new int[] { 0, 0, 1, -1 };
        int[] dj = new int[] { 1, -1, 0, 0 };

        List<Pos> ret = new ArrayList<>();
        for (int k = 0; k < 4; k++) {
            int ni = zeroI + di[k];
            int nj = zeroJ + dj[k];
            if ( ni >= 0 && nj >=0 && ni < 2 && nj < 3) {
                int[][] new_board = new int[2][3];
                  new_board[0] = new int[] { pos.a, pos.b, pos.c };
        new_board[1] = new int[] { pos.d, pos.e, pos.f };

                int tt = new_board[ni][nj];
                new_board[ni][nj] = 0;
                new_board[zeroI][zeroJ] = tt;

                Pos newPos = new Pos(new_board[0][0], new_board[0][1], new_board[0][2], new_board[1][0], new_board[1][1], new_board[1][2]);

                ret.add(newPos);

            }
        }

        return ret;

    }


    static class Pos {

        int a, b, c, d, e, f;

        public Pos(int a, int b, int c, int d, int e, int f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            Pos otherPos = (Pos) other;
            return
                a == otherPos.a &&
                b == otherPos.b &&
                c == otherPos.c &&
                d == otherPos.d &&
                e == otherPos.e &&
                f == otherPos.f;


        }

        public int hashCode() {
            int res = 17;
            res += 31 * res + a;
            res += 31 * res + b;
            res += 31 * res + c;
            res += 31 * res + d;
            res += 31 * res + e;
            res += 31 * res + f;

            return res;
        }
    }
}
