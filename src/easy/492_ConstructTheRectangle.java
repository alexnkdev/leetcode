class Solution {
    public int[] constructRectangle(int area) {
        int[] ret = null;
        for (int length = 1; length <= area; length++) {
            if (area % length == 0) {
                int width = area / length;
                if (length >= width) {
                    ret = ret == null || length - width < ret[0] - ret[1] ? new int[] {length, width} : ret;
                }
            }
        }
        return ret;
    }
}