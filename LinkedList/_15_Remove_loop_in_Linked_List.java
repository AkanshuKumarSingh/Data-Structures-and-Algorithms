package LinkedList;

public class _15_Remove_loop_in_Linked_List {

	static class Node{
	    int data;
	    Node next;
	}
	
    public static void removeLoop(Node head){
        
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                slow = null;
                break;
            }
        }
        
        if(slow != null) return;
        else if(head == fast){
            Node t = head;
            while(t.next != head)
                t=t.next;
            t.next = null;
            return;
        }
        
        Node t1 = head, t2 = fast;
        while(t1.next != t2.next){
            t1 = t1.next;
            t2 = t2.next;
        }
        
        t2.next = null;
    }

}
