package LinkedList;

public class _41_Find_nk_th_node_in_Linked_list {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static int nknode(Node head, int k) {
		int n = 0;
		Node curr = head;
		while (curr != null) {
			curr = curr.next;
			n++;
		}

		int nk = (int) Math.ceil((float) n / (float) k);
		curr = head;
		while (nk-- > 1) {
			curr = curr.next;
		}

		return curr.data;

	}
}
