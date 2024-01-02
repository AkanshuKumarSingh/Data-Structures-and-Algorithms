package LinkedList;

public class _53_Partition_Linked_List_around_given_value {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static Node partition(Node node, int x) {
		Node gHead = null, gTail = null;
		Node mHead = null, mTail = null;
		Node lHead = null, lTail = null;
		Node curr = node;
		while (curr != null) {
			Node next = curr.next;
			if (curr.data < x) {
				if (gHead == null) {
					gHead = gTail = curr;
					curr.next = null;
				} else {
					gTail.next = curr;
					gTail = curr;
					curr.next = null;
				}
			} else if (curr.data == x) {
				if (mHead == null) {
					mHead = mTail = curr;
					curr.next = null;
				} else {
					mTail.next = curr;
					mTail = curr;
					curr.next = null;
				}
			} else {
				if (lHead == null) {
					lHead = lTail = curr;
					curr.next = null;
				} else {
					lTail.next = curr;
					lTail = curr;
					curr.next = null;
				}
			}
			curr = next;
		}

		if (gHead == null) {
			if (mHead == null) {
				return lHead;
			} else {
				mTail.next = lHead;
				return mHead;
			}
		} else if (mHead == null) {
			gTail.next = lHead;
			return gHead;
		} else if (lHead == null) {
			gTail.next = mHead;
			return gHead;
		}
		gTail.next = mHead;
		mTail.next = lHead;
		return gHead;
	}

}
