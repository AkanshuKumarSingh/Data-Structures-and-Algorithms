package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class _37_Union_of_Two_Linked_Lists {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node findUnion(Node head1, Node head2) {
		ArrayList<Integer> list = new ArrayList<>();
		Node t = head1;
		while (t != null) {
			list.add(t.data);
			t = t.next;
		}

		t = head2;
		while (t != null) {
			list.add(t.data);
			t = t.next;
		}

		Collections.sort(list);
		int prev = -1;
		Node head = new Node(-1), curr = head;
		for (int no : list) {
			if (prev != no) {
				Node node = new Node(no);
				curr.next = node;
				curr = node;
				prev = no;
			}
		}
		return head.next;
	}

}
