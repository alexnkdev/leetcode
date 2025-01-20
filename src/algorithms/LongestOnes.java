package algorithms;

public class LongestOnes {

	public int longestOnes(int[] A, int K) {
		int left = 0;
		int n = A.length;
		int[] numOnes = new int[A.length];
		numOnes[0] = A[0];
		for (int i = 1; i < n; i++) {
			numOnes[i] = numOnes[i - 1] + A[i];
		}
		int ret = 0;
		for (int i = 0; i < n; i++) {
			int totalOnes = numOnes[i] - (left > 0 ? numOnes[left - 1] : 0);
			int length = i - left + 1;
			int totalZeroes = length - totalOnes;
			if (totalZeroes > K) {
				while (left <= i) {
					if (A[left] == 0) {
						totalZeroes--;
					}
					left++;
					if (totalZeroes <= K) {
						break;
					}
				}
			}
			ret = Math.max(ret,  i - left + 1);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestOnes().longestOnes(new int[] { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 } , 3));
	}

}
