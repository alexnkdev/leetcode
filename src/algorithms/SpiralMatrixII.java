package algorithms;

public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int ci = 0;
        int cj = 0;
        int current = 1;
        int direction = 0;
        int[] di = new int[] { 0, 1, 0, -1 };
        int[] dj = new int[] { 1, 0, -1, 0 };
        while (current < n * n) {
            ret[ci][cj] = current;
            int ni = ci + di[direction];
            int nj = cj + dj[direction];
            if (ni < 0 || nj < 0 || ni >= n || nj >= n
               || ret[ni][nj] != 0) {
                direction = (direction + 1) % 4;
            } else {
                current++;
                ci = ni;
                cj = nj;
            }
        }
        ret[ci][cj] = current;
        return ret;
    }
	
	public static void main(String[] args) {
		new SpiralMatrixII().generateMatrix(5);
	}

}
