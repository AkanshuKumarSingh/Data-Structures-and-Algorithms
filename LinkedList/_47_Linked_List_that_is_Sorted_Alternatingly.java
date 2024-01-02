package LinkedList;

public class _47_Linked_List_that_is_Sorted_Alternatingly {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node reverse(Node head) {
		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		return prev;
	}

	Node mergeResult(Node head1, Node head2) {
		if (head1 == null) {
			return reverse(head2);
		} else if (head2 == null) {
			return reverse(head1);
		}

		Node head = null, tail = null;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				if (head == null) {
					head = tail = head1;
					head1 = head1.next;
					tail.next = null;
				} else {
					tail.next = head1;
					tail = head1;
					head1 = head1.next;
					tail.next = null;
				}
			} else {
				if (head == null) {
					head = tail = head2;
					head2 = head2.next;
					tail.next = null;
				} else {
					tail.next = head2;
					tail = head2;
					head2 = head2.next;
					tail.next = null;
				}
			}

		}

		if (head1 != null) {
			tail.next = head1;
		} else {
			tail.next = head2;
		}

		return head;
	}

	public Node sort(Node head) {
		Node curr1 = head, curr2 = head.next, head2 = head.next;
		while (curr2 != null) {
			Node next1 = curr2.next, next2 = null;
			if (next1 != null) {
				next2 = next1.next;
			}
			curr1.next = next1;
			curr1 = next1;
			curr2.next = next2;
			curr2 = next2;
		}
		head2 = reverse(head2);

		return mergeResult(head, head2);
	}

}
