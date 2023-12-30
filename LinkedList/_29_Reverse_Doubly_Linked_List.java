package LinkedList;

public class _29_Reverse_Doubly_Linked_List {

	
	static class Node
	{
	    int data;
	    Node next, prev;
	    Node(int data)
	    {
	        this.data = data;
	        this.next = null;
	        this.prev = null;
	    }
	}
	
	public static Node reverseDLL(Node  head)
	{
	    Node curr = head, t = null;
	    while(curr != null){
	        Node next = curr.next;
	        Node prev = curr.prev;
	        
	        curr.prev = next;
	        curr.next = prev;
	        t = curr;
	        curr = next;
	    } 
	    head = t;
	    return head;
	}
	
}
