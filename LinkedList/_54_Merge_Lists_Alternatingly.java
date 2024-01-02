package LinkedList;

public class _54_Merge_Lists_Alternatingly {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void mergeAlt(Node head1, Node head2) {
		Node curr1 = head1, curr2 = head2, head = head1;
		while (curr1 != null && curr2 != null) {
			Node next1 = curr1.next;
			Node next2 = curr2.next;
			curr1.next = curr2;
			curr2.next = next1;
			curr1 = next1;
			curr2 = next2;
		}

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();

		while (curr2 != null) {
			System.out.print(curr2.data + " ");
			curr2 = curr2.next;
		}

	}

}
