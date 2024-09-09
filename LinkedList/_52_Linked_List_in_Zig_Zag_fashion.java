package LinkedList;

public class _52_Linked_List_in_Zig_Zag_fashion {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
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
        boolean flag = true; 
        
        Node current = head; 
        while (current != null && current.next != null) { 
            if (flag == true){ 
                if (current.data > current.next.data) { 
                    int temp = current.data; 
                    current.data = current.next.data; 
                    current.next.data = temp; 
                } 
            } 
            else{
                if (current.data < current.next.data) { 
                    int temp = current.data; 
                    current.data = current.next.data; 
                    current.next.data = temp; 
                } 
            } 
  
            current = current.next; 
            flag = !(flag); 
        }
    return head;

//		Node slow = head, fast = head.next;
//		while (fast != null && fast.next != null) {
//			slow = slow.next;
//			fast = fast.next.next;
//		}
//
//		Node head2 = slow.next;
//		slow.next = null;
//		head2 = reverse(head2);
//		Node c1 = head, c2 = head2;
//		while (c2 != null) {
//			int no1 = c1.data, no2 = c2.data;
//			c1.data = no2 - no1;
//			c2.data = no1;
//			c1 = c1.next;
//			c2 = c2.next;
//		}
//
//		head2 = reverse(head2);
//		slow.next = head2;
//		return head;
	}

}
