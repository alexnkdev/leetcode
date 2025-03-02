class Solution {

    static int[] dr = new int[] { 0, 0, 1, -1 };
    static int[] dc = new int[] { 1, -1, 0, 0 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void fill(int[][] image, int r, int c, int colorToFill, int fillColor) {
        image[r][c] = fillColor;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == colorToFill) {
                fill(image, nr, nc, colorToFill, fillColor);
            }
        }
    }
}