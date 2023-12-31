package Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Sort_K_sorted_Array {

	public static void sortIt(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.offer(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			pq.offer(arr[i]);
			System.out.println(pq.poll());
		}

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int k = Integer.parseInt(br.readLine());
		sortIt(arr,k);
	}
}
