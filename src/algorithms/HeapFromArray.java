package algorithms;

import java.util.Arrays;

public class HeapFromArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 10, 4, 5, 6, 7, 8, 9, 5 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		buildHeap(arr);
		for (int i = arr.length - 1;  i >= 0; i--) {
			int t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;
			heapify(arr, i, 0);
		}
	}

	private static void buildHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
	}

	private static void heapify(int[] arr, int n, int idx) {
		int largest = idx;
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != idx) {
			int t = arr[idx];
			arr[idx] = arr[largest];
			arr[largest] = t;
			heapify(arr, n, largest);
		}
	}

}
