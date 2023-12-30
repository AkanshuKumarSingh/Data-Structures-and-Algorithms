package LinkedList;

public class _23_Flattening_Linked_List {

	static class Node
	{
		int data;
		Node next;
		Node bottom;
		
		Node(int d)
		{
			data = d;
			next = null;
			bottom = null;
		}
	}
	
    Node sortedMerge(Node head1, Node head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        Node head = null, tail = null;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                if(head == null){
                    head = tail = head1;
                    head1 = head1.bottom;
                    tail.bottom = null;
                }else{
                    tail.bottom = head1;
                    tail = head1;
                    head1 = head1.bottom;
                    tail.bottom = null;
                }
            }else{
                if(head == null){
                    head = tail = head2;
                    head2 = head2.bottom;
                    tail.bottom = null;
                }else{
                    tail.bottom = head2;
                    tail = head2;
                    head2 = head2.bottom;
                    tail.bottom = null;
                }
            }
        }
        
        if(head1 != null){
            tail.bottom = head1;
        }else{
            tail.bottom = head2;
        }
        
        return head;
      }
    
    Node flatten(Node root)
    {
        if(root == null) return root;
        Node next = root.next;
        root.next = null;
        Node nextRoot = flatten(next);
        root = sortedMerge(root, nextRoot);
        return root;
    }
	
}
