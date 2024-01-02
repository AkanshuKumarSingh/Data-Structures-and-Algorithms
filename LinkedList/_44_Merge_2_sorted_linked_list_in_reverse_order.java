package LinkedList;

public class _44_Merge_2_sorted_linked_list_in_reverse_order {

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
	
    Node reverse(Node head){
        Node prev = null;
		Node curr = head;
		
		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		return prev;
    }
    
    Node mergeResult(Node head1, Node head2)
    {
        if(head1 == null){
            return reverse(head2);
        }else if(head2 == null){
            return reverse(head1);
        }
        
        Node head = null, tail = null;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                if(head == null){
                    head = tail = head1;
                    head1 = head1.next;
                    tail.next = null;
                }else{
                    tail.next = head1;
                    tail = head1;
                    head1 = head1.next;
                    tail.next = null;
                }
            }else{
                if(head == null){
                    head = tail = head2;
                    head2 = head2.next;
                    tail.next = null;
                }else{
                    tail.next = head2;
                    tail = head2;
                    head2 = head2.next;
                    tail.next = null;
                }
            }
            
        }
        
        if(head1 != null){
            tail.next = head1;
        }else{
            tail.next = head2;
        }
		
		return reverse(head);
    }
	
}
