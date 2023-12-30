package LinkedList;

public class _17_Rotate_a_Linked_List {

	static class Node{
	    int data;
	    Node next;
	    Node(int d){
	        data=d;
	        next=null;
	    }
	}
	
    public Node rotate(Node head, int k) {
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        
        while(k-- > 0){
            Node next = head.next;
            head.next = null;
            tail.next = head;
            tail = head;
            head = next;
        }
        
        return head;
    }
	
}
