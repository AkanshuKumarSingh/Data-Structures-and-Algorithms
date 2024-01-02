package LinkedList;

public class _57_Arrange_Consonants_and_Vowels {

	static class Node {
	    char data;
	    Node next;
	    
	    public Node(char data){
	        this.data = data;
	        next = null;
	    }
	}
	
    public Node arrangeCV(Node head){
        Node sv = new Node('v'), cv = sv;
        Node sc = new Node('c'), cc = sc;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            if(curr.data == 'a' || curr.data == 'e' || curr.data == 'i' || curr.data == 'o' || curr.data == 'u'){
                cv.next = curr;
                cv = curr;
            }else{
                cc.next = curr;
                cc = curr;
            }
            curr.next = null;
            curr = next;
        }
        cv.next = sc.next;
        return sv.next;
    }
	
}
