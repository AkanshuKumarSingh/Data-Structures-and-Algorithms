package LinkedList;

public class _36_Reorder_List {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node reverse(Node head) {
		Node curr = head, prev = null;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}

	void reorderlist(Node head) {

		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node nHead = slow.next;
		slow.next = null;
		nHead = reverse(nHead);
		Node c1 = head, c2 = nHead;
		while (c2 != null) {
			Node t1 = c1.next;
			Node t2 = c2.next;
			c1.next = c2;
			c2.next = t1;

			c1 = t1;
			c2 = t2;
		}

	}

}
