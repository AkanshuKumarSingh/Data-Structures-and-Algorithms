package LinkedList;

public class _28_Pairwise_swap_elements_of_linked_list {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public Node pairwiseSwap(Node head) {
		if (head == null || head.next == null)
			return head;

		Node first = head, second = head.next, prev = head;
		while (true) {
			Node next = second.next;
			first.next = next;
			second.next = first;
			if (head == first) {
				head = second;
				prev = first;
			} else {
				prev.next = second;
				prev = first;
			}

			if (next == null || next.next == null)
				return head;

			first = next;
			second = next.next;
		}
	}

}
