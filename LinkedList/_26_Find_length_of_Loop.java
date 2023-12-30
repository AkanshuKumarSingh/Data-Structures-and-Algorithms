package LinkedList;

public class _26_Find_length_of_Loop {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static int countNodesinLoop(Node head) {

		// System.out.println("HHM");
		if (head == null || head.next == null)
			return 0;
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (slow != fast) {
			return 0;
		}
		int cnt = 1;
		slow = slow.next;
		while (slow != fast) {
			slow = slow.next;
			cnt++;
		}
		return cnt;
	}

}
