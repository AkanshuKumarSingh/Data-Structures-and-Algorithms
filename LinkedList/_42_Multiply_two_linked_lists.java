package LinkedList;

public class _42_Multiply_two_linked_lists {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public long multiplyTwoLists(Node l1, Node l2) {
		// System.out.println("HHM");
		long N = 1000000007;
		long n1 = 0;
		long n2 = 0;
		while (l1 != null) {
			n1 = ((n1 * 10) + l1.data) % N;
			l1 = l1.next;
		}

		while (l2 != null) {
			n2 = ((n2 * 10) + l2.data) % N;
			l2 = l2.next;
		}

		return (n1 * n2) % N;
	}

}
