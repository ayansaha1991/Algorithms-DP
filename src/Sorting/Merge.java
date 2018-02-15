package Sorting;

public class Merge {

	public static void main(String[] args) {

		int[] arr = { 10, 9, 8, 8, 8, 5, 100, 1, 52, 6, 1, -1 };
		int[] aux = new int[arr.length];

		Merge.sort(arr, aux, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void sort(int[] arr, int[] aux, int low, int high) {

		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;

		sort(arr, aux, low, mid);
		sort(arr, aux, mid + 1, high);
		merge(arr, aux, low, mid, high);

	}

	private static void merge(int[] arr, int[] aux, int low, int mid, int high) {

		for (int i = 0; i < arr.length; i++) {
			aux[i] = arr[i];
		}

		int i = low;
		int j = mid + 1;

		for (int k = low; k <= high; k++) {

			if (i > mid) {
				arr[k] = aux[j++];
			} else if (j > high) {
				arr[k] = aux[i++];
			} else if (aux[i] <= aux[j]) {
				arr[k] = aux[i++];
			} else if (aux[i] > aux[j]) {
				arr[k] = aux[j++];
			}

		}
	}

}
