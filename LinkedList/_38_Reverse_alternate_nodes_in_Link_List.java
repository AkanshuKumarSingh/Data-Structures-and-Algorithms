package LinkedList;

public class _38_Reverse_alternate_nodes_in_Link_List {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	static Node reverse(Node head) {
		Node curr = head, prev = null;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}

	public static void rearrange(Node head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		Node curr1 = head, curr2 = head.next, head1 = head.next, prev = null;
		while (curr1 != null && curr2 != null) {
			Node next1 = curr2.next;
			Node next2 = next1 != null ? next1.next : null;
			curr1.next = next1;
			prev = curr1;
			curr1 = next1;
			curr2.next = next2;
			curr2 = next2;
		}

		head1 = reverse(head1);

		if (curr1 == null) {
			prev.next = head1;
		} else {
			curr1.next = head1;
		}

	}

}
