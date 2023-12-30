package LinkedList;

public class _19_Add_1_to_number_represented_as_linked_list {

	static class Node{
	    int data;
	    Node next;
	    
	    Node(int x){
	        data = x;
	        next = null;
	    }
	} 
	
    public static int add(Node head){
        if(head.next == null){
            int no = head.data + 1;
            head.data = no%10;
            return no/10;
        }else{
            int no = head.data + add(head.next);
            head.data = no%10;
            return no/10;
        }
    }
    
    public static Node addOne(Node head) 
    { 
        int no = add(head);
        if(no != 0){
            Node node = new Node(no);
            node.next = head;
            head = node;
        }
        return head;
    }
	
}
