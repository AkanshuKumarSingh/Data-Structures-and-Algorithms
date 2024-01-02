package LinkedList;

public class _40_Delete_N_nodes_after_M_nodes_of_linked_list {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static void linkdelete(Node head, int M, int N) {
		if (N == 0)
			return;
		Node curr = head;
		while (curr != null) {
			for (int i = 1; i < M && curr != null; i++) {
				curr = curr.next;
			}
			if (curr == null)
				return;
			Node del = curr.next;
			curr.next = null;
			for (int i = 1; i < N && del != null; i++) {
				del = del.next;
			}
			if (del == null)
				return;
			curr.next = del.next;
			curr = curr.next;
		}
	}

}
