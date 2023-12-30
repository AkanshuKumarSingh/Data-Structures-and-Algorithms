package LinkedList;

import java.util.HashMap;

public class _25_Intersection_of_two_sorted_Linked_lists {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node findIntersection(Node head1, Node head2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Node head = head1;
		while (head != null) {
			map.put(head.data, map.getOrDefault(head.data, 0) + 1);
			head = head.next;
		}

		head = head2;
		Node newHead = new Node(0), t = newHead;
		while (head != null) {
			int freq = map.getOrDefault(head.data, 0);
			if (freq > 0) {
				Node node = new Node(head.data);
				t.next = node;
				t = node;
				map.put(head.data, freq - 1);
				head = head.next;
			} else {
				head = head.next;
			}
		}
		return newHead.next;
	}

}
