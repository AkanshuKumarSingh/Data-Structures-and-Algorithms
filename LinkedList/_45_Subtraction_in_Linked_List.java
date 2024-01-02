package LinkedList;

public class _45_Subtraction_in_Linked_List {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static int subtract(Node h1, int sz1, Node h2, int sz2, Node res) {
		if (h1 == null)
			return 0;
		int carry, no;
		if (sz1 > sz2) {
			carry = subtract(h1.next, sz1 - 1, h2, sz2, res);
			no = h1.data + carry;
		} else {
			carry = subtract(h1.next, sz1 - 1, h2.next, sz2 - 1, res);
			no = h1.data - h2.data + carry;
		}

		if (no < 0) {
			no = no + 10;
			carry = -1;
		} else {
			carry = 0;
		}

		Node node = new Node(no);
		node.next = res.next;
		res.next = node;
		return carry;
	}

	static Node subLinkedList(Node l1, Node l2) {
		int sz1 = 0, sz2 = 0;
		Node res = new Node(-1);
		Node c1 = l1, c2 = l2;
		while (c1 != null) {
			if (!(sz1 == 0 && c1.data == 0)) {
				if (sz1 == 0)
					l1 = c1;
				sz1++;
			}
			c1 = c1.next;
		}
		while (c2 != null) {
			if (!(sz2 == 0 && c2.data == 0)) {
				if (sz2 == 0)
					l2 = c2;
				sz2++;
			}
			c2 = c2.next;
		}
		if (sz1 > sz2) {
			subtract(l1, sz1, l2, sz2, res);
		} else if (sz1 < sz2) {
			subtract(l2, sz2, l1, sz1, res);
		} else {
			c1 = l1;
			c2 = l2;
			while (c1 != null && c1.data == c2.data) {
				c1 = c1.next;
				c2 = c2.next;
			}
			if (c1 != null && c1.data < c2.data) {
				subtract(l2, sz2, l1, sz1, res);
			} else if (c1 != null) {
				subtract(l1, sz1, l2, sz2, res);
			}
		}

		Node ans = res.next;
		while (ans != null) {
			if (ans.data == 0) {
				ans = ans.next;
			} else {
				break;
			}
		}
		return ans == null ? new Node(0) : ans;
	}

}
