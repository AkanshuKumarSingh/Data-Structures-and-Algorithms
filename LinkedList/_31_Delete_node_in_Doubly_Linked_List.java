package LinkedList;

public class _31_Delete_node_in_Doubly_Linked_List {

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}

	Node deleteNode(Node head, int x) {
		if (x == 1) {
			head = head.next;
			if (head != null)
				head.prev = null;
			return head;
		}

		Node curr = head;
		while (x-- > 1) {
			curr = curr.next;
		}

		Node prev = curr.prev;
		Node next = curr.next;
		prev.next = next;
		if (next != null)
			next.prev = prev;

		return head;
	}

}
