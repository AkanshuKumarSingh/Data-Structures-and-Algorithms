package LinkedList;

public class _16_Detect_Loop_in_linked_list {

	static class Node
	{
	    int data;
	    Node next;
	    Node(int d) {data = d; next = null; }
	}
	
    public static boolean detectLoop(Node head){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        
        return false;
    }
	
}
