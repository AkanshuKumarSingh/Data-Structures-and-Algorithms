package Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _2_k_largest_elements {

	public static void kLargest(int arr[], int k) {
		// o(nlog(k))
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < k; i++) {
			pq.offer(arr[i]);
		}
		
		for(int i = k ; i < arr.length; i++) {
			if(pq.peek() < arr[i]) {
				pq.poll();
				pq.offer(arr[i]);
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}

	public static void kLargestNaive(int arr[], int k) {
		//O(nlog(n))
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int no : arr) {
			pq.add(no);
		}

		int cnt = arr.length - k;
		while (cnt-- > 0) {
			pq.poll();
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
		// write your code here

	}
}
