package Hashing;

import java.util.HashMap;

public class _38_Intersection_of_Two_Linked_Lists {

	static class Node {
		int data;
		Node next;

		Node(int a) {
			data = a;
			next = null;
		}
	}

	public static Node findIntersection(Node head1, Node head2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Node head = null, tail = null;
		while (head2 != null) {
			map.put(head2.data, 1);
			head2 = head2.next;
		}
		while (head1 != null) {
			if (map.containsKey(head1.data)) {
				map.put(head1.data, 2);
				Node node = new Node(head1.data);
				if (head == null) {
					head = tail = node;
				} else {
					tail.next = node;
					tail = node;
				}
			}
			head1 = head1.next;
		}
		return head;
	}

}
