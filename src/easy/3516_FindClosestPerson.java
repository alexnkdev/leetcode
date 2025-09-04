class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(y - z);
        if (dist1 < dist2) {
            return 1;
        } else if (dist1 > dist2) {
            return 2;
        }
        return 0;
    }
}
