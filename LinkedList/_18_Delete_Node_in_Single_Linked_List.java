package LinkedList;

public class _18_Delete_Node_in_Single_Linked_List {

	class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
    Node deleteNode(Node head, int x)
    {
	    if(head == null) return head;
	    else if(x == 1) return head.next;
	    
	    int cnt = 2;
	    Node t = head;
	    while(cnt < x){
	        t = t.next;
	        cnt++;
	    }
	    t.next = t.next.next;
	    return head;
    }
	
}
