class Solution {

    Map<Pos, Boolean> reachable = new HashMap<>();
    Map<Integer, Integer> pos_to_idx = new HashMap<>();

    boolean is_reachable(int[] stones, int idx, int last_jump) {
        if (idx == 0 && last_jump == 1) {
            return true;
        }
        if (idx == 0) {
            return false;
        }
        Pos pos = new Pos(idx, last_jump);
        if (reachable.containsKey(pos)) {
            return reachable.get(pos);
        }

        boolean ok = false;
        int prev_pos = stones[idx] - last_jump;
        if (prev_pos == 0) {
            return last_jump == 1;
        } else if (prev_pos >= 0) {
          Integer stone_idx = pos_to_idx.get(prev_pos);
          if (stone_idx != null) {
            ok |= is_reachable(stones, stone_idx, last_jump);
            ok |= last_jump - 1 > 0 && is_reachable(stones, stone_idx, last_jump - 1);
            ok |= is_reachable(stones, stone_idx, last_jump + 1);
          }
        }
        reachable.put(pos, ok);
        return ok;
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        reachable.put(new Pos(0, 0), true);
        pos_to_idx.put(0, 0);
        for (int i = 1; i < n; i++) {
            pos_to_idx.put(stones[i], i);
        }

        int max_jump = n * (n + 1) + 2;
        for (int i = 1; i < max_jump; i++) {
            if (is_reachable(stones, n - 1, i)) {
                return true;
            }    
        }

        return false;
    }

    static class Pos {
        
        int i;
        int jump;

        public Pos(int i, int jump) {
            this.i = i;
            this.jump = jump;
        }

        public boolean equals(Object other) {
            if (this == other) return true;
            Pos other_pos = (Pos) other;
            return other_pos.i == i && other_pos.jump == jump;
        }

        public int hashCode() {
            int res = 17;
            res = 31 * res + i;
            res = 31 * res + jump;
            return res;
        }

    }
}
