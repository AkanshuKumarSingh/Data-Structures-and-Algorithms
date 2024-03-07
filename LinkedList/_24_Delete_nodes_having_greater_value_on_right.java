package LinkedList;

public class _24_Delete_nodes_having_greater_value_on_right {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node reverse(Node head) {
		Node curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	Node compute1(Node head) {
		if (head == null || head.next == null)
			return head;
		head = reverse(head);
		Node prev = head;
		Node curr = head.next;

		while (curr != null) {
			if (curr.data < prev.data) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				curr = curr.next;
				prev = prev.next;
			}
		}
		return reverse(head);
	}

	Node compute(Node head) {
		if (head == null || head.next == null)
			return head;
		head = reverse(head);
		Node prev = head;
		Node curr = head.next;
		int maxTillNow = head.data;

		while (curr != null) {
			if (curr.data < maxTillNow) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				maxTillNow = curr.data;
				curr = curr.next;
				prev = prev.next;
			}
		}

		return reverse(head);
	}

}
