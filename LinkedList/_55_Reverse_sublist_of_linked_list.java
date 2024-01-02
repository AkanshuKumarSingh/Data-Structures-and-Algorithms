package LinkedList;

public class _55_Reverse_sublist_of_linked_list {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node reverse(Node head) {
		Node prev = null;
		Node curr = head, tail = head;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static Node reverseBetween(Node head, int m, int n) {
		Node start = head, end = head;
		if (m == 1) {
			while (n-- > 1) {
				end = end.next;
			}
			Node newTail = head;
			Node next = end.next;
			end.next = null;
			head = reverse(head);
			newTail.next = next;
			return head;
		}

		while (m-- > 2) {
			start = start.next;
		}
		while (n-- > 1) {
			end = end.next;
		}
		Node sHead = start.next;
		start.next = null;
		Node next = end.next;
		end.next = null;
		start.next = reverse(sHead);
		sHead.next = next;
		return head;
	}

}
