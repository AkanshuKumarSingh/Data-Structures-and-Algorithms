package LinkedList;

public class _27_Insert_in_Sorted_List {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node sortedInsert(Node head, int key) {
		if (head.data >= key) {
			Node node = new Node(key);
			node.next = head;
			head = node;
			return head;
		} else {
			Node curr = head.next, prev = head;
			while (curr != null) {
				if (curr.data > key) {
					Node node = new Node(key);
					node.next = curr;
					prev.next = node;
					prev = curr;
					return head;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			prev.next = new Node(key);
			return head;
		}
	}

}
