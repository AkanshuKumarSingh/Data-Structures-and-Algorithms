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

	public static Node findIntersection1(Node head1, Node head2) {
		Node nHead = new Node(0), t = nHead;
		while (head1 != null && head2 != null) {
			if (head1.data == head2.data) {
				Node node = new Node(head1.data);
				t.next = node;
				t = node;
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1.data < head2.data) {
				head1 = head1.next;
			} else {
				head2 = head2.next;
			}
		}
		return nHead.next;
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
