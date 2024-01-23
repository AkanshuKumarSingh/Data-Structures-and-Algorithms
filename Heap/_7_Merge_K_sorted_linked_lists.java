package Heap;

import java.util.PriorityQueue;

public class _7_Merge_K_sorted_linked_lists {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	static class Pair implements Comparable<Pair> {
		Node node;

		Pair(Node node) {
			this.node = node;
		}

		public int compareTo(Pair obj) {
			return this.node.data - obj.node.data;
		}
	}

	Node mergeKList(Node[] arr, int K) {
		Node head = null, tail = null;
		PriorityQueue<Pair> q = new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			q.offer(new Pair(arr[i]));
		}

		while (!q.isEmpty()) {
			Pair p = q.poll();
			Node next = p.node.next;
			p.node.next = null;

			if (head == null) {
				head = tail = p.node;
			} else {
				tail.next = p.node;
				tail = p.node;
			}

			if (next != null)
				q.offer(new Pair(next));
		}

		return head;
	}

}
