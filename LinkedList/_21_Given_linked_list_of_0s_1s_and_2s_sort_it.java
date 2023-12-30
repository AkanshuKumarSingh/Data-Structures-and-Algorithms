package LinkedList;

public class _21_Given_linked_list_of_0s_1s_and_2s_sort_it {
	static class Node
	{
	    int data;
	    Node next;
	    Node(int data)
	    {
	        this.data = data;
	        next = null;
	    }
	}

    static Node segregate(Node head)
    {
        // System.out.print("HHM");
        Node low = new Node(-1),l = low;
        Node mid = new Node(-1),m = mid;
        Node high = new Node(-1),h = high;
        Node curr = head;
        
        while(curr != null){
            if(curr.data == 0){
                low.next = curr;
                low = curr;
                curr = curr.next;
                low.next = null;
            }else if(curr.data == 1){
                mid.next = curr;
                mid = curr;
                curr = curr.next;
                mid.next = null;
            }else if(curr.data == 2){
                high.next = curr;
                high = curr;
                curr = curr.next;
                high.next = null;
            }
        }
        
        mid.next = h.next;
        low.next = m.next;
        l = l.next;
        return l; 
        
    }
	
}
