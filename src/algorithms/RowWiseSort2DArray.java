package algorithms;

import java.util.Arrays;
import java.util.Random;

public class RowWiseSort2DArray {

	public static void main(String[] args) {
		int n = 5;
		int[][] nums = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = new Random().nextInt(100);
			}
		}
		print(nums);
		sort(nums);
		print(nums);
	}

	private static void sort(int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			Arrays.sort(nums[i]);
		}
	}

	private static void print(int[][] nums) {
		System.out.println("--");
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}

}
