package LinkedList;

import java.util.LinkedList;

import LinkedList._11_Reverse_A_Linked_List_data_Iterative.Node;

class linkedList {

	private class Node {
		private int data;
		private Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int size = 0;

	private void handleWhenSize0(int data) {
		Node nn = new Node(data);
		head = tail = nn;
		size = 1;
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
	
	Node left;
	int sz = 0;
	
	public void reverseDIRecursive(Node node, int level) {
		if(node == null) {
			sz = level;
			return;
		}
		
		reverseDIRecursive(node.next, level+1);
		
		if(level >= sz/2) {
			int t = node.data;
			node.data = left.data;
			left.data = t;
			left = left.next;
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
	
}

public class _1_My_Linked_List {

	public static void main(String[] args) {
		linkedList list = new linkedList();
		list.addFirst(12);
		list.addFirst(19);
		System.out.println(list);
		list.display();
		list.addLast(4);
		System.out.println(list);
		list.addAt(54, 1);
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list);
		System.out.println(list.removeLast());
		System.out.println(list);
		list.addFirst(18);
		list.addFirst(11);
		System.out.println(list);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(2));
		System.out.println(list.removeAt(2));
		System.out.println(list);
		System.out.println(list.size());
		
	}

}
