package LinkedList;

public class _58_Insertion_Sort_for_Singly_Linked_List {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node insertionSort(Node head_ref) {
		Node sorted = null;
		Node head = head_ref;
		while (head != null) {
			Node next = head.next;
			head.next = null;
			if (sorted == null || sorted.data >= head.data) {
				head.next = sorted;
				sorted = head;
			} else {
				Node curr = sorted;
				while (curr.next != null && curr.next.data < head.data) {
					curr = curr.next;
				}
				head.next = curr.next;
				curr.next = head;
			}
			head = next;
		}
		return sorted;
	}

}
