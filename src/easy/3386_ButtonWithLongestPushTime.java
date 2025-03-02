class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxTime = events[0][1];
        int maxButtonIndex = events[0][0];
        for (int i = 1; i < events.length; i++) {
            int diff = events[i][1] - events[i - 1][1];
            if (diff > maxTime || (diff == maxTime && events[i][0] < maxButtonIndex)) {
                maxTime = diff;
                maxButtonIndex = events[i][0];
            }
        }
        return maxButtonIndex;
    }
}