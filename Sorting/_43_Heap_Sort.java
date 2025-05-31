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

//	class HeapSorter:
//	    def build_heap(self, arr, n):
//	        for i in range(n // 2 - 1, -1, -1):
//	            self.heapify(arr, n, i)
//
//	    def heapify(self, arr, n, i):
//	        left = 2 * i + 1
//	        right = 2 * i + 2
//	        min_idx = i
//
//	        if left < n and arr[left] < arr[min_idx]:
//	            min_idx = left
//
//	        if right < n and arr[right] < arr[min_idx]:
//	            min_idx = right
//
//	        if min_idx != i:
//	            arr[i], arr[min_idx] = arr[min_idx], arr[i]
//	            self.heapify(arr, n, min_idx)
//
//	    def heap_sort(self, arr):
//	        n = len(arr)
//	        self.build_heap(arr, n)
//
//	        for i in range(n - 1, 0, -1):
//	            arr[0], arr[i] = arr[i], arr[0]
//	            self.heapify(arr, i, 0)
//
//	        # Reverse the array to get ascending order from min-heap sort
//	        l, r = 0, n - 1
//	        while l < r:
//	            arr[l], arr[r] = arr[r], arr[l]
//	            l += 1
//	            r -= 1

	
}
