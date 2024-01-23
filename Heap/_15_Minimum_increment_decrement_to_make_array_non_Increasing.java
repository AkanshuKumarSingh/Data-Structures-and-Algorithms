package Heap;

import java.util.PriorityQueue;

public class _15_Minimum_increment_decrement_to_make_array_non_Increasing {

	public static int minOperations1(int a[], int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int steps = 0;
		for (int i = 0; i < n; i++) {
			if (!q.isEmpty() && q.peek() < a[i]) {
				steps += (a[i] - q.peek());
//	            q.offer(a[i]);
				q.remove();
			}
			q.offer(a[i]);
			System.out.println(i + ", " + steps + ", " + q.peek() + ", " + q);
		}
		return steps;
	}

	public static int minOperations2(int a[], int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int steps = 0;
		for (int i = 0; i < n; i++) {
			if (!q.isEmpty() && q.peek() < a[i]) {
				steps += (a[i] - q.peek());
				q.offer(a[i]);
				q.remove();
			}
			q.offer(a[i]);
			System.out.println(i + ", " + steps + ", " + q.peek() + ", " + q);
		}
		return steps;
	}

	public static void main(String args[]) {
		int[] arr = { 17, 15, 60, 50, 81, 53 };// , 40, 55, 99, 66};
		System.out.println(minOperations1(arr, arr.length));
		System.out.println();
		System.out.println(minOperations2(arr, arr.length));
	}

}
