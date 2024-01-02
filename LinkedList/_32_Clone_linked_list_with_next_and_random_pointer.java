package LinkedList;

public class _32_Clone_linked_list_with_next_and_random_pointer {

	static class Node {
		int data;
		Node next, arb;

		Node(int d) {
			data = d;
			next = arb = null;

		}
	}

	Node copyList(Node head) {
		Node temp = head;
		while (temp != null) {
			Node node = new Node(temp.data);
			Node next = temp.next;
			node.next = next;
			temp.next = node;
			temp = temp.next.next;
		}

		temp = head;
		while (temp != null) {
			Node arb = temp.arb;
			if (arb != null)
				temp.next.arb = arb.next;
			temp = temp.next.next;
		}

		Node newHead = null, curr = null;
		temp = head;
		while (temp != null) {
			Node add = temp.next;
			if (newHead == null) {
				newHead = add;
				curr = add;
				temp.next = temp.next.next;
				temp = temp.next;
				curr.next = null;
			} else {
				curr.next = add;
				curr = add;
				temp.next = temp.next.next;
				temp = temp.next;
				curr.next = null;
			}
		}

		return newHead;
	}

}
