package LinkedList;

import LinkedList._47_Linked_List_that_is_Sorted_Alternatingly.Node;

public class _48_Modify_Linked_List_1 {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static Node modifyTheList(Node head) {
		Node slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node head2 = slow.next;
		slow.next = null;
		head2 = reverse(head2);
		Node c1 = head, c2 = head2;
		while (c2 != null) {
			int no1 = c1.data, no2 = c2.data;
			c1.data = no2 - no1;
			c2.data = no1;
			c1 = c1.next;
			c2 = c2.next;
		}

		head2 = reverse(head2);
		slow.next = head2;
		return head;
	}

//	class Node:
//	    def __init__(self, data):
//	        self.data = data
//	        self.next = None
//
//	def reverse(head):
//	    prev = None
//	    curr = head
//
//	    while curr:
//	        next_node = curr.next
//	        curr.next = prev
//	        prev = curr
//	        curr = next_node
//
//	    return prev
//
//	def modify_the_list(head):
//	    if not head or not head.next:
//	        return head
//
//	    # Step 1: Find middle of the list
//	    slow = head
//	    fast = head.next
//	    while fast and fast.next:
//	        slow = slow.next
//	        fast = fast.next.next
//
//	    # Step 2: Reverse second half
//	    head2 = slow.next
//	    slow.next = None
//	    head2 = reverse(head2)
//
//	    # Step 3: Modify first half and second half
//	    c1 = head
//	    c2 = head2
//	    while c2:
//	        no1 = c1.data
//	        no2 = c2.data
//	        c1.data = no2 - no1
//	        c2.data = no1
//	        c1 = c1.next
//	        c2 = c2.next
//
//	    # Step 4: Reverse back and attach
//	    head2 = reverse(head2)
//	    slow.next = head2
//
//	    return head
//
//	# Helper to print the list
//	def print_list(head):
//	    while head:
//	        print(head.data, end=" -> ")
//	        head = head.next
//	    print("None")
//
//	# Example usage
//	head = Node(10)
//	head.next = Node(4)
//	head.next.next = Node(5)
//	head.next.next.next = Node(3)
//	head.next.next.next.next = Node(6)
//
//	print("Original list:")
//	print_list(head)
//
//	head = modify_the_list(head)
//
//	print("Modified list:")
//	print_list(head)

	
}
