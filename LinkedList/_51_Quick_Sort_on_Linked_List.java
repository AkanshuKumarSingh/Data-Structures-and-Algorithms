package LinkedList;

public class _51_Quick_Sort_on_Linked_List {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static Node partitionLast(Node start, Node end) {
		if (start == end || start == null || end == null)
			return start;
		Node curr = start, ptr = start, prev = null;
		while (curr != end) {
			if (curr.data < end.data) {
				prev = ptr;
				int t = curr.data;
				curr.data = ptr.data;
				ptr.data = t;
				ptr = ptr.next;
			}
			curr = curr.next;
		}

		int t = curr.data;
		curr.data = ptr.data;
		ptr.data = t;

		return prev;
	}

	public static void sort(Node head, Node tail) {
		if (head == null || tail == null || head == tail) {
			return;
		}

		Node sortedNode = partitionLast(head, tail);

		if (sortedNode == null) {
			sort(head.next, tail);
		} else if (sortedNode.next == tail) {
			sort(head, sortedNode);
		} else {
			sort(head, sortedNode);
			if (sortedNode != null && sortedNode.next != null)
				sort(sortedNode.next.next, tail);
		}
	}

	public static Node quickSort(Node node) {
		if (node == null || node.next == null)
			return node;
		Node tail = node, head = node;
		while (tail.next != null) {
			tail = tail.next;
		}

		sort(head, tail);
		return node;
	}

}
