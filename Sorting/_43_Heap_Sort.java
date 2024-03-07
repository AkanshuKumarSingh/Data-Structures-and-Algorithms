package Sorting;

public class _43_Heap_Sort {

	// Function to build a Heap from array.
	void buildHeap(int arr[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

	}

	// Heapify function to maintain heap property.
	void heapify(int arr[], int n, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int min = i;

		if (left < n && arr[left] < arr[min]) {
			min = left;
		}

		if (right < n && arr[right] < arr[min]) {
			min = right;
		}

		if (min != i) {
			int t = arr[i];
			arr[i] = arr[min];
			arr[min] = t;
			heapify(arr, n, min);
		}
	}

	// Function to sort an array using Heap Sort.
	public void heapSort(int arr[], int n) {
		buildHeap(arr, n);
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}

		int l = 0, r = n - 1;
		while (l < r) {
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;
			r--;
		}

	}

}
