package LinkedList;

public class _56_Remove_all_occurences_of_duplicates_in_linked_list {

	static class Node {
		int data;
		Node next;
	}

	public static Node removeAllDuplicates(Node head) {
		Node newHead = null, prev = null;
		while (head != null && head.next != null) {
			if (head.data == head.next.data) {
				while (head.next != null && head.data == head.next.data) {
					head = head.next;
				}
				head = head.next;
			} else if (newHead == null) {
				newHead = head;
				prev = head;
				head = head.next;
				prev.next = null;
			} else {
				prev.next = head;
				prev = head;
				head = head.next;
				prev.next = null;
			}
		}
		if (head != null && prev != null)
			prev.next = head;
		else if (head != null && prev == null)
			return head;
		return newHead;
	}

}
