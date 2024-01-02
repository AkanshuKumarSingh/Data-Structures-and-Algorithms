package LinkedList;

public class _34_Sorted_insert_for_circular_linked_list {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node sortedInsert(Node head, int data) {
		if (data <= head.data) {
			Node node = new Node(data);
			node.next = head;
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = node;
			head = node;
			return head;
		}

		Node curr = head.next, prev = head;
		while (curr != head) {
			if (data <= curr.data) {
				Node node = new Node(data);
				node.next = curr;
				prev.next = node;
				return head;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}

		Node node = new Node(data);
		node.next = head;
		prev.next = node;
		return head;

	}

}
