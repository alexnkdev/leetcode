class Solution {
    public long coloredCells(int n) {
        long sum = ((long) n - 1) * ((long) n - 1);
        sum = sum * 2;
        sum += 2 * n - 1;
        return sum;
    }
}