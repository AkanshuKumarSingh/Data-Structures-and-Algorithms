package LinkedList;

import java.util.LinkedList;

class linkedList1 {

	private Node head = null;
	private Node tail = null;
	private int size = 0;

	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node() {
			this.data = 0;
			this.next = null;
		}

		@Override
		public String toString() {
			return Integer.toString(data);
		}
	}

	private void handleWhenSize0(int data) {
		Node node = new Node(data);
		head = tail = node;
		size = 1;
	}

	public void addFirst(int data) {
		if (size == 0) {
			handleWhenSize0(data);
		} else {
			Node node = new Node(data);
			node.next = head;
			head = node;
			size++;
		}
	}

	public void addLast(int data) {
		if (size == 0) {
			handleWhenSize0(data);
		} else {
			Node node = new Node(data);
			tail.next = node;
			tail = node;
			size++;
		}
	}

	public Node getNodeAt(int indx) {
		Node temp = head;

		while (indx-- > 0) {
			temp = temp.next;
		}

		return temp;
	}

	public void addAt(int data, int indx) {
		if (indx < 0 && indx > size) {
			System.out.println("Addition : Out of Index Exception");
			return;
		} else if (indx == 0) {
			addFirst(data);
		} else if (indx == size) {
			addLast(data);
		} else {
			Node node = getNodeAt(indx - 1);
			Node newNode = new Node(data);
			newNode.next = node.next;
			node.next = newNode;
			size++;
		}
	}

	private int handleRemoveWhenSize1() {
		Node node = head;
		head = tail = null;
		size--;
		return node.data;
	}

	public int removeFirst() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			return handleRemoveWhenSize1();
		} else {
			int val = head.data;
			head = head.next;
			size--;
			return val;
		}
	}

	public int removeLast() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			return handleRemoveWhenSize1();
		} else {
			Node node = getNodeAt(size - 2);
			int val = node.next.data;
			node.next = null;
			tail = node;
			size--;
			return val;
		}

	}

	public int removeAt(int indx) {
		if (indx < 0 || indx >= size) {
			System.out.println("Not present");
			return -1;
		} else if (indx == 0) {
			return removeFirst();
		} else if (indx == size - 1) {
			return removeLast();
		} else {
			Node node = getNodeAt(indx - 1);
			int val = node.next.data;
			node.next = node.next.next;
			size--;
			return val;
		}
	}

//	public int getFirst() {
//	
//	}
//
//	public int getLast() {
//	}
//
//	public int getAt(int indx) {
//	}
//
//	public int size() {
//	}

	public void display() {
	}

	@Override
	public String toString() {
		String str = "";
		Node temp = head;

		while (temp != null) {
			str += temp.data + "->";
			temp = temp.next;
		}

		str += "null";

		return str;
	}

}

public class prac {

	static int min(int a, int b) {
		return (a > b) ? b : a;
	}

	static int minSwap(int arr[], int n, int k) {

		// Find count of elements which are
		// less than equals to k
		int count = 0;
		for (int i = 0; i < n; ++i)
			if (arr[i] <= k)
				++count;

		// Find unwanted elements in current
		// window of size 'count'
		int bad = 0;
		for (int i = 0; i < count; ++i)
			if (arr[i] > k)
				++bad;

		// Initialize answer with 'bad' value of
		// current window
		int ans = bad;
		for (int i = 0, j = count; j < n; ++i, ++j) {

			// Decrement count of previous window
			if (arr[i] > k)
				--bad;

			// Increment count of current window
			if (arr[j] > k)
				++bad;

			// Update ans if count of 'bad'
			// is less in current window
			ans = min(ans, bad);
		}
		return ans;
	}

	public static void main(String[] args) {
		
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Adding elements to the LinkedList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.addFirst("First Fruit"); // Adding at the beginning
        list.addLast("Last Fruit"); // Adding at the end

        // Displaying the LinkedList
        System.out.println("LinkedList: " + list);

        // Accessing elements
        String firstElement = list.getFirst(); // Get first element
        String lastElement = list.getLast(); // Get last element
        String elementAtIndex2 = list.get(2); // Get element at index 2

        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
        System.out.println("Element at Index 2: " + elementAtIndex2);
        System.out.println(list);
        System.out.println("Element at Index 2: " + list.remove());

		
		int nk = (int) Math.ceil((float)15 / (float)2);
		System.out.println(nk);

		int n = 2;
		while (n-- > 0) {
			System.out.println(n);
		}

		LinkedList<Integer> nos = new LinkedList<>();
		nos.add(2);
		nos.add(3);
		nos.add(4);
		System.out.println(nos);
		System.out.println(nos.removeFirst());
		for (int i : nos) {
			System.out.println(i);
		}

//		linkedList1 list = new linkedList1();
//		list.addFirst(23);
//		list.addLast(21);
//		list.addFirst(98);
//		System.out.println(list);
//		System.out.println(list.getNodeAt(1));
//		list.addAt(11, 2);
//		System.out.println(list);
//
//		System.out.println("\n\n");
//
//		System.out.println(minSwap(new int[] { 2, 5, 1, 5, 6, 3 }, 6, 3));

	}

}
