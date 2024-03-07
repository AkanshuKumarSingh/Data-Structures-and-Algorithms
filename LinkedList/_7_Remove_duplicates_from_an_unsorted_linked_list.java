package LinkedList;

import java.util.HashSet;

public class _7_Remove_duplicates_from_an_unsorted_linked_list {

	public static class Node{
	    int data;
	    Node next;
	    Node(int d) {
	        data = d; 
	        next = null;
	    }
	}
	
    public Node removeDuplicates(Node head) 
    {
        if(head == null || head.next == null) return head;
        HashSet<Integer> set = new HashSet<>();
		Node curr = head.next, prev = head;
		set.add(head.data);
		
		while(curr != null){
		    if(set.contains(curr.data)){
		        prev.next = curr.next;
		        curr = curr.next;
		    }else{
		        prev = curr;
		        curr = curr.next;
		        set.add(prev.data);
		    }
		}
		return head;
    }
	
}
