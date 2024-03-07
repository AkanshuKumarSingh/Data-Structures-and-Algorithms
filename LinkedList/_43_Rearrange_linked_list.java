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

	void rearrangeEvenOdd1(Node head) {
//		Node o = new Node(-1), t1 = o;
//		Node e = new Node(-1), t2 = e;
//		int no = 1;
//		while (head == null) {
//			Node next = head.next;
//			head.next = null;
//			if (no % 2 == 1) {
//				t1.next = head;
//				t1 = head;
//			} else {
//				t2.next = head;
//				t2 = head;
//			}
//			head = next;
//			no++;
//		}
//		t1.next = e.next;
		if (head == null || head.next == null)
			return;
		Node t1 = head;
		Node nHead = head.next, t2 = nHead;
		Node curr = nHead.next;
		t1.next = null;
		t2.next = null;
		int no = 1;
		while (curr != null) {
			Node next = curr.next;
			curr.next = null;
			if (no % 2 == 1) {
				t1.next = curr;
				t1 = curr;
			} else {
				t2.next = curr;
				t2 = curr;
			}
			no++;
			curr = next;
		}
		t1.next = nHead;
	}

}
