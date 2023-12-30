package LinkedList;

public class _22_Check_If_Circular_Linked_List {
	
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
    boolean isCircular(Node head)
    {
    // 	System.out.println("HHM");
	    Node start = head;
	    while(head != null){
	        if(head.next == start) return true;
	        head = head.next;
	    }
		
		return false;
    }
}
