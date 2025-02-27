class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        List<String> directions = List.of("UP", "RIGHT",
        "DOWN", "LEFT");
        int[] ni = new int[] { -1, 0, 1, 0 };
        int[] nj = new int[] { 0, 1, 0, -1 };
        for (int c = 0; c < commands.size(); c++) {
            int k = directions.indexOf(commands.get(c));
            i = i + ni[k];
            j = j + nj[k];
        }
        return (i * n) + j;
    }
}