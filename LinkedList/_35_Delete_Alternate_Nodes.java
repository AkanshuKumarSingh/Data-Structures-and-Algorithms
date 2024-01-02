package LinkedList;

public class _35_Delete_Alternate_Nodes {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void deleteAlternate(Node head) {
		Node curr = head;
		while (curr != null && curr.next != null) {
			curr.next = curr.next.next;
			curr = curr.next;
		}
	}

}
