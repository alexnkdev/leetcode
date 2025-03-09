class Solution {
    public List<String> validStrings(int n) {
        List<String> ret = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean good = true;
            for (int i = 0; i < n - 1; i++) {
                int current = ((mask & (1 << i)) != 0) ? 1 : 0;
                int next = ((mask & (1 << (i + 1))) != 0) ? 1 : 0;
                if (current == 0 && next == 0) {
                    good = false;
                    break;
                }
            }
            if (good) {
                String set = "";
                for (int i = 0; i < n; i++) {
                    int val = (mask & (1 << i)) != 0 ? 1 : 0;
                    set += "" + val;
                }
                ret.add(set);
            }
        }
        return ret;
    }
}