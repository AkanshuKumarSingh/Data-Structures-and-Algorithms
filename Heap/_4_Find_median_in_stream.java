package Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _4_Find_median_in_stream {

	public static class MedianPriorityQueue {
		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;

		public MedianPriorityQueue() {
			left = new PriorityQueue<>(Collections.reverseOrder());
			right = new PriorityQueue<>();
		}

		public void add(int val) {
			if (right.size() > 0 && val > right.peek()) {
				right.add(val);
			} else {
				left.add(val);
			}

			if (left.size() - right.size() == 2) {
				right.add(left.poll());
			} else if (right.size() - left.size() == 2) {
				left.add(right.poll());
			}

		}

		public int remove() {
			if (this.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}
			if (right.size() > left.size()) {
				return right.poll();
			} else {
				// if size are equal or left is greater in size in both case we need to return left.
				return left.poll();
			}
		}

		public int peek() {
			if (this.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}
			if (right.size() > left.size()) {
				return right.peek();
			} else {
				return left.peek();
			}
		}

		public int size() {
			return left.size() + right.size();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MedianPriorityQueue qu = new MedianPriorityQueue();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("add")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				qu.add(val);
			} else if (str.startsWith("remove")) {
				int val = qu.remove();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("peek")) {
				int val = qu.peek();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(qu.size());
			}
			str = br.readLine();
		}
	}
}
