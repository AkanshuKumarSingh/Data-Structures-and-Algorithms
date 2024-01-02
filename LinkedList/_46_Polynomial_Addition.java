package LinkedList;

public class _46_Polynomial_Addition {

	static class Node {
		int coeff;
		int pow;
		Node next;

		Node(int a, int b) {
			coeff = a;
			pow = b;
			next = null;
		}
	}

	public static Node addPolynomial(Node p1, Node p2) {
		Node curr1 = p1, curr2 = p2;
		Node head = new Node(-1, -1), curr = head;
		while (curr1 != null && curr2 != null) {
			if (curr1.pow == curr2.pow) {
				Node node = new Node(curr1.coeff + curr2.coeff, curr1.pow);
				curr.next = node;
				curr = node;
				curr1 = curr1.next;
				curr2 = curr2.next;
			} else if (curr1.pow > curr2.pow) {
				Node node = new Node(curr1.coeff, curr1.pow);
				curr.next = node;
				curr = node;
				curr1 = curr1.next;
			} else {
				Node node = new Node(curr2.coeff, curr2.pow);
				curr.next = node;
				curr = node;
				curr2 = curr2.next;
			}
		}

		if (curr1 != null) {
			curr.next = curr1;
		} else if (curr2 != null) {
			curr.next = curr2;
		}

		return head.next;
	}

}
