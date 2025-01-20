package algorithms;

public class KnightProbability {

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] p = new double[N][N][K + 1];
        p[r][c][0] = 1;
        int[] di = new int[] { -2, -1, 1, 2, 2, 1, -2, -1 } ;
        int[] dj = new int[] { 1, 2, 2, 1, -1, -2, -1, -2 };
        for (int k = 0; k < K; k++) {
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			for (int d = 0; d < 8; d++) {
        				int ni = i + di[d];
        				int nj = j + dj[d];
        				if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
        					p[ni][nj][k + 1] += p[i][j][k] / 8;
        				}
        			}
        		}
        	}
        }
        double ret = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		ret += p[i][j][K];
        	}
        }
        return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println(new KnightProbability().knightProbability(3, 2, 0, 0));
    }
	
}
