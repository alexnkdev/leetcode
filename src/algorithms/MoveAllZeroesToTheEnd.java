package algorithms;

import java.util.Arrays;

public class MoveAllZeroesToTheEnd {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 2, 0, 0, 3, 3, 3, 3, 4, 0, 4, 0, 3, 1 };
		int i = 0;
		int nonZeroPointer = 0;
		while (i < arr.length) {
			arr[nonZeroPointer] = arr[i];
			if (arr[i] != 0) {
				nonZeroPointer++;
				i++;
			} else {
				i++;
			}
		}
		while (nonZeroPointer < arr.length) {
			arr[nonZeroPointer++] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
}
