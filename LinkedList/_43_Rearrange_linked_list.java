package LinkedList;

public class _43_Rearrange_linked_list {

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void rearrangeEvenOdd(Node head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		Node nHead = head.next, c1 = head, c2 = nHead, t1 = null, t2 = null, prev = null;
		while (c2 != null) {
			t1 = c2.next;
			c1.next = t1;
			prev = c1;
			c1 = t1;

			if (t1 != null) {
				t2 = t1.next;
			} else {
				break;
			}
			c2.next = t2;
			c2 = t2;
		}
		if (t1 == null)
			prev.next = nHead;
		else
			t1.next = nHead;
	}

}
