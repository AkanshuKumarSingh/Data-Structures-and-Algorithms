package LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _5_Merge_Sort_A_Linked_List {

	public static class Node {
		int data;
		Node next;
	}

	public static class LinkedList {
		Node head;
		Node tail;
		int size;

		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;

			if (size == 0) {
				head = tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}

			size++;
		}

		public int size() {
			return size;
		}

		public void display() {
			for (Node temp = head; temp != null; temp = temp.next) {
				System.out.print(temp.data + " ");
			}
			System.out.println();
		}

		public void removeFirst() {
			if (size == 0) {
				System.out.println("List is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				head = head.next;
				size--;
			}
		}

		public int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return head.data;
			}
		}

		public int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return tail.data;
			}
		}

		public int getAt(int idx) {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
				return -1;
			} else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
		}

		public void addFirst(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = head;
			head = temp;

			if (size == 0) {
				tail = temp;
			}

			size++;
		}

		public void addAt(int idx, int val) {
			if (idx < 0 || idx > size) {
				System.out.println("Invalid arguments");
			} else if (idx == 0) {
				addFirst(val);
			} else if (idx == size) {
				addLast(val);
			} else {
				Node node = new Node();
				node.data = val;

				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}
				node.next = temp.next;

				temp.next = node;
				size++;
			}
		}

		public void removeLast() {
			if (size == 0) {
				System.out.println("List is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				Node temp = head;
				for (int i = 0; i < size - 2; i++) {
					temp = temp.next;
				}

				tail = temp;
				tail.next = null;
				size--;
			}
		}

		public void removeAt(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
			} else if (idx == 0) {
				removeFirst();
			} else if (idx == size - 1) {
				removeLast();
			} else {
				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}

				temp.next = temp.next.next;
				size--;
			}
		}

		private Node getNodeAt(int idx) {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}

		public void reverseDI() {
			int li = 0;
			int ri = size - 1;
			while (li < ri) {
				Node left = getNodeAt(li);
				Node right = getNodeAt(ri);

				int temp = left.data;
				left.data = right.data;
				right.data = temp;

				li++;
				ri--;
			}
		}

		public void reversePI() {
			if (size <= 1) {
				return;
			}

			Node prev = null;
			Node curr = head;
			while (curr != null) {
				Node next = curr.next;

				curr.next = prev;
				prev = curr;
				curr = next;
			}

			Node temp = head;
			head = tail;
			tail = temp;
		}

		public int kthFromLast(int k) {
			Node slow = head;
			Node fast = head;
			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}

			while (fast != tail) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow.data;
		}

		public int mid() {
			Node f = head;
			Node s = head;

			while (f.next != null && f.next.next != null) {
				f = f.next.next;
				s = s.next;
			}

			return s.data;
		}

		public static Node midNode(Node head, Node tail) {
			Node f = head;
			Node s = head;

			while (f.next != tail && f.next.next != tail) {
				f = f.next.next;
				s = s.next;
			}

			return s;
		}

		public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
			LinkedList ml = new LinkedList();

			Node one = l1.head;
			Node two = l2.head;
			while (one != null && two != null) {
				if (one.data < two.data) {
					ml.addLast(one.data);
					one = one.next;
				} else {
					ml.addLast(two.data);
					two = two.next;
				}
			}

			while (one != null) {
				ml.addLast(one.data);
				one = one.next;
			}

			while (two != null) {
				ml.addLast(two.data);
				two = two.next;
			}

			return ml;
		}

		public static LinkedList mergeSort(Node head, Node tail) {
			if (head.equals(tail)) {
				LinkedList l = new LinkedList();
				l.addFirst(head.data);
				return l;
			}
			
			Node mid = midNode(head, tail);
			Node next = mid.next;
				
			// Also we can do  mid.next = null at this point and do mid.next = next after merging but 
			// we have to change midNode fxn just we have to put condition fast.next != null && fast.nex.next != null 
			
			LinkedList l1 = mergeSort(head, mid);
			LinkedList l2 = mergeSort(next, tail);
			LinkedList res = mergeTwoSortedLists(l1, l2);
			
			return res;

		}
		
		
		
		// GFG
	    static Node getMiddle(Node head) {
			if(head == null) {
				return head;
			}
			Node slow = head;
			Node fast = head;
			while(fast.next != null && fast.next.next != null) {
				slow = fast.next;
				fast = fast.next.next;
			}
			return slow;
		}
		
	    static Node sortedMerge(Node head1, Node head2) {
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
	        
	        return head;
	      } 

	    
	    //Function to sort the given linked list using Merge Sort.
	    static Node mergeSort(Node head)
	    {
	        if(head == null || head.next == null) {
				return head;
			}
	        Node mid = getMiddle(head);
	        Node midNextHead = mid.next;
	        mid.next = null;
	        
	        Node firstHead = mergeSort(head);
	        Node secondHead = mergeSort(midNextHead);
	        head = sortedMerge(firstHead, secondHead);
	        return head;
	        
	    }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n1 = Integer.parseInt(br.readLine());
		LinkedList l1 = new LinkedList();
		String[] values1 = br.readLine().split(" ");
		for (int i = 0; i < n1; i++) {
			int d = Integer.parseInt(values1[i]);
			l1.addLast(d);
		}

		LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
		sorted.display();
		l1.display();
	}

}
