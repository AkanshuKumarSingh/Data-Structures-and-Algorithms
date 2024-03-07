package LinkedList;

public class _39_Swapping_Nodes_in_Linked_List {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode swapNodes1(ListNode head, int k) {

		if (head == null || head.next == null)
			return head;

		ListNode len = head;
		int length = 0;

		while (len != null) {
			len = len.next;
			length++;
		}

		ListNode curr1 = head;
		ListNode curr2 = head;

		int l = length - k;

		while (k-- > 1) {
			curr1 = curr1.next;
		}

		while (l-- > 0) {
			curr2 = curr2.next;
		}

		if (curr1 == curr2)
			return head;

		curr1.val = curr1.val + curr2.val;
		curr2.val = curr1.val - curr2.val;
		curr1.val = curr1.val - curr2.val;
		return head;

	}

	public ListNode swapNodes(ListNode head, int k) {
		int len = 0;
		ListNode t1 = head, t2 = head;
		while (t1 != null) {
			t1 = t1.next;
			len++;
		}

		if (k >= len)
			return head;

		t1 = head;
		int n1 = k - 1;
		int n2 = len - 1 - k;

		while (n1-- > 1) {
			t1 = t1.next;
		}

		while (n2-- > 0) {
			t2 = t2.next;
		}

		// System.out.println(t2.data);
		// return t2;
		if (k == 1) {
			ListNode next1 = head.next;
			ListNode next2 = t2.next.next;
			ListNode node2 = t2.next;
			head.next = next2;
			t2.next = head;
			node2.next = next1;
			head = node2;
			return head;
		}

		ListNode node1 = t1.next;
		ListNode node2 = t2.next;
		ListNode next1 = t1.next.next;
		ListNode next2 = t2.next.next;
		t1.next = node2;
		node2.next = next1;
		t2.next = node1;
		node1.next = next2;
		return head;

	}

}
