package LinkedList;

public class _49_Circular_Linked_List_Traversal {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void printList(Node head) {
		Node curr = head;
		while (curr.next != head) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.print(curr.data);
	}

}
