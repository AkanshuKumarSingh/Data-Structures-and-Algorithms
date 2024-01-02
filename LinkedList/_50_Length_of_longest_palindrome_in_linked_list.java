package LinkedList;

public class _50_Length_of_longest_palindrome_in_linked_list {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static int count(Node n1, Node n2) {
		int cnt = 0;
		while (n1 != null && n2 != null) {
			if (n1.data == n2.data)
				cnt++;
			else
				break;
			n1 = n1.next;
			n2 = n2.next;
		}
		return 2 * cnt;
	}

	public static int maxPalindrome(Node head) {
		int result = 0;
		Node prev = null, curr = head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			result = Math.max(result, count(prev, next) + 1);
			result = Math.max(result, count(curr, next));
			prev = curr;
			curr = next;
		}
		return result;
	}

}
