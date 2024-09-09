package LinkedList;

public class _56_Remove_all_occurences_of_duplicates_in_linked_list {

	static class Node {
		int data;
		Node next;
	}
	
    public static Node removeAllDuplicates1(Node head)
    {
        Node curr = head, prev = new Node(), newHead = null;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                int no = curr.data;
                while(curr != null && curr.data == no) curr = curr.next;
                prev.next = curr;
            }else{
                if(newHead == null) newHead = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        
        if(newHead == null && curr != null) return curr;
        return newHead;
    }

	public static Node removeAllDuplicates(Node head) {
		Node newHead = null, prev = null;
		while (head != null && head.next != null) {
			if (head.data == head.next.data) {
				while (head.next != null && head.data == head.next.data) {
					head = head.next;
				}
				head = head.next;
			} else if (newHead == null) {
				newHead = head;
				prev = head;
				head = head.next;
				prev.next = null;
			} else {
				prev.next = head;
				prev = head;
				head = head.next;
				prev.next = null;
			}
		}
		
		// Case when we have ip of: 1->2->2->3
		if (head != null && prev != null)
			prev.next = head;
		// Case when we have ip of: 2->2->3
		else if (head != null && prev == null)
			return head;
		return newHead;
	}

}
