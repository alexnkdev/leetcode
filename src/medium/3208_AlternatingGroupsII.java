class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 0;
        int j = 0;
        int ret = 0;
        int windowLength = 1;
        while (i < colors.length) {
            int next = (j + 1) % colors.length;
            if (windowLength == k) {
                ret++;
            }
            if (colors[next] == colors[j]) {
                // can't move j forward
                if (next < i) {
                    break;
                }
                j = next;
                if (j <= i) {
                    break;
                }
                i = next;
                windowLength = 1;
            } else {
                // can move j forward
                j = next;
                if (windowLength == k) {
                    i = (i + 1) % colors.length;
                    if (i == 0) {
                        break;
                    }
                } else {
                    windowLength++;
                }
            }
        }
        return ret;
    }
}