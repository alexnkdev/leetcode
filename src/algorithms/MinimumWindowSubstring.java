package algorithms;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		char[] alphabet = new char[] { 'a', 'b', 'c', 'd' };
		String s = "aabcad";
		int n = s.length();
		int k = alphabet.length;
		boolean[][][] ok = new boolean[n][n][k];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int t = 0; t < k; t++) {
					ok[i][j][t] = ok[i][j - 1][t];
					ok[i][j][t] |= s.charAt(j) == alphabet[t];
				}
			}
		}
		
	}

}
