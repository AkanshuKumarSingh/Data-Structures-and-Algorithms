package LinkedList;

public class _20_Delete_without_head_pointer {

	static class Node
	{
		int data ;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }
	
}
