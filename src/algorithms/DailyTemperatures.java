package algorithms;

import java.util.Arrays;

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {
		int[] ret = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			int j = i + 1;
			while (j < T.length && T[j] <= T[i]) {
				j++;
			}
			if (j < T.length) {
				ret[i] = j - i ;
			} else {
				ret[i] = 0;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

}
