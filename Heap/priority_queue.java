package Heap;

import java.util.ArrayList;

public class priority_queue {

	private ArrayList<Integer> data;

	public priority_queue() {
		data = new ArrayList<>();
	}

	public priority_queue(int arr[]) {
		data = new ArrayList<>();

//		high complexity ways -> more than O(nlogn)
//		for(int val : arr) {
//			add(val);
//		}

//      optimise approach - O(n)
		for (int val : arr) {
			data.add(val);
		}

		for (int i = data.size() - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	private void swap(int i, int j) {
		int iVal = data.get(i);
		int jVal = data.get(j);

		data.set(i, jVal);
		data.set(j, iVal);
	}

	private void upheapify(int indx) {
		int parentIdx = (indx - 1) / 2;
		if (parentIdx >= 0 && data.get(parentIdx) > data.get(indx)) {
			swap(indx, parentIdx);
			upheapify(parentIdx);
		}
	}

	public void add(int val) {
		data.add(val);
		upheapify(data.size() - 1);
	}

	public void downheapify(int idx) {
		int lci = 2 * idx + 1;
		int rci = 2 * idx + 2;

		int minIndex = idx;
		if (lci < data.size() && data.get(lci) < data.get(minIndex)) {
			minIndex = lci;
		}
		if (rci < data.size() && data.get(rci) < data.get(minIndex)) {
			minIndex = rci;
		}

		if (minIndex != idx) {
			swap(idx, minIndex);
			downheapify(minIndex);
		}
	}

	public int remove() {
		if (data.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}
		int val = data.get(0);
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		downheapify(0);
		return val;
	}

	public int peek() {
		if (data.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 9, 6, 3, 12, 4, 45, 78, 1, 45, 6, 2 };
		priority_queue pq = new priority_queue(arr);
//		for(int val : arr) {
//			pq.add(val);
//		}

		while (pq.size() > 0) {
			int val = pq.remove();
			System.out.println(val);
		}
	}

}
