package LinkedList;

public class _30_Delete_Middle_of_Linked_List {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node deleteMid(Node head) {
		if (head == null || head.next == null)
			return null;
		Node slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		return head;
	}

}
