package LinkedList;

public class LinkedListTest {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		
		Node(int data){
			this.data = data;
		}		
	}
	
	Node head = null;
	Node tail = null;
	int size = 0;
	
	private void handleWhenSize0(int data) {
		
	}
	
	public void addFirst(int data) {
		if(size == 0) {
			handleWhenSize0(data);
		}else {
			Node nn = new Node(data);
			nn.next = head;
			head = nn;
			size++;
		}
	}

	public void addLast(int data) {
		if(size == 0) {
			handleWhenSize0(data);
		}else {
			Node nn = new Node(data);
			tail.next = nn;
			tail = nn;
			size++;
		}
	}

	public Node getNodeAt(int indx) {
		Node temp = this.head;
		
		while(indx > 0) {
			temp = temp.next;
			indx--;
		}
		
		return temp;
	}
	
	public void addAt(int data, int indx) {
		if(indx < 0 || indx > size) {
			System.out.println("Addition : Out of Index Exception");
			return;
		}else if(indx == 0) {
			addFirst(data);
		}else if(indx == size) {
			addLast(data);
		}else {
			Node nm1 = getNodeAt(indx-1);
			Node nn = new Node(data);
			nn.next = nm1.next;
			nm1.next = nn;
			size++;
		}
	}

	private int handleRemoveWhenSize1() {
		int val = head.data;
		head = tail = null;
		size = 0;
		return val;
	}
	
	public int removeFirst() {
		if(size == 0) {
			System.out.println("Not present");
			return -1;
		}else if(size == 1) {
			return handleRemoveWhenSize1();
		}else {
			int val = head.data;
			head = head.next;
			size--;
			return val;
		}
		
	}

	public int removeLast() {
		if(size == 0) {
			System.out.println("Not present");
			return -1;
		}else if(size == 1) {
			return handleRemoveWhenSize1();
		}else {
			Node nm1 = getNodeAt(size-2);
			int val = tail.data;
			nm1.next = null;
			tail = nm1;
			size--;
			return val;
		}
	}

	public int removeAt(int indx) {
		if(indx < 0 || indx >= size) {
			System.out.println("Not present");
			return -1;
		}else if(indx == 0) {
			return removeFirst();
		}else if(indx == size-1) {
			return  removeLast();
		}else {
			Node nm1 = getNodeAt(indx-1);
			Node n = nm1.next;
			int val = n.data;
			nm1.next = n.next;
//			int val = nm1.next.data;
//			nm1.next = nm1.next.next;
			size--;
			return val;
		}
	}

	public int getFirst() {
		if(size == 0) {
			return -1;
		}
		return head.data;
	}

	public int getLast() {
		if(size == 0) {
			return -1;
		}
		return tail.data;
	}

	public int getAt(int indx) {
		if(indx < 0 || indx >= size) {
			return -1;
		}else if(indx == 0) {
			return getFirst();
		}else if(indx == size-1) {
			return getLast();
		}else {
			Node n = getNodeAt(indx);
			return n.data;
		}
	}

	public int size() {
		return size;
	}

	public void display() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		
		System.out.println("null");
		
	}

	@Override
	public String toString() {
		String str = "";
		Node temp = head;
		
		while(temp != null) {
			str += temp.data+"->";
			temp = temp.next;
		}
		
		str += "null";
		
		return str;
	}

	
	public static void main(String[] args) {
		

	}

}
