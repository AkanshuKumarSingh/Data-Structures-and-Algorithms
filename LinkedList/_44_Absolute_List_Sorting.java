package LinkedList;

public class _44_Absolute_List_Sorting {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node sortList(Node head) {
		if (head == null || head.next == null)
			return head;
		Node prev = head, curr = head.next;
		while (curr != null) {
			if (curr.data < 0) {
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

}
