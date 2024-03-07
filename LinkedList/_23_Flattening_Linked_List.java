package LinkedList;

import java.util.PriorityQueue;

public class _23_Flattening_Linked_List {

	static class Node {
		int data;
		Node next;
		Node bottom;

		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}

	static class NodeComparator implements java.util.Comparator<Node> {
		@Override
		public int compare(Node a, Node b) {
			return a.data - b.data;
		}
	}

	public static void flatten1(Node root) {

		// Priority queue to store nodes
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());

		// Adding main linked list nodes into priority queue
		while (root != null) {
			pq.add(root);
			root = root.next;
		}

		// Extracting the minimum node
		// while priority queue is not empty
		while (!pq.isEmpty()) {
			// Extracting the minimum node
			Node k = pq.poll();

			// Printing the node data
			System.out.print(k.data + " ");
			if (k.bottom != null) {
				pq.add(k.bottom);
			}
		}
	}

	Node sortedMerge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;

		Node head = null, tail = null;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				if (head == null) {
					head = tail = head1;
					head1 = head1.bottom;
					tail.bottom = null;
				} else {
					tail.bottom = head1;
					tail = head1;
					head1 = head1.bottom;
					tail.bottom = null;
				}
			} else {
				if (head == null) {
					head = tail = head2;
					head2 = head2.bottom;
					tail.bottom = null;
				} else {
					tail.bottom = head2;
					tail = head2;
					head2 = head2.bottom;
					tail.bottom = null;
				}
			}
		}

		if (head1 != null) {
			tail.bottom = head1;
		} else {
			tail.bottom = head2;
		}

		return head;
	}

	Node flatten(Node root) {
		if (root == null)
			return root;
		Node next = root.next;
		root.next = null;
		Node nextRoot = flatten(next);
		root = sortedMerge(root, nextRoot);
		return root;
	}

}
