class Solution {
    public int[] sumZero(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            ret.add(i+1);
            ret.add(-(i+1));
        }
        if (n % 2 == 1) {
            ret.add(0);
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
}
