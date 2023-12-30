package LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14_Add_Two_Linked_Lists {
	public static class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
		
		Node(){
			
		}
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

		public static Node midNode(Node head, Node tail) {
			Node f = head;
			Node s = head;

			while (f != tail && f.next != tail) {
				f = f.next.next;
				s = s.next;
			}

			return s;
		}

		public static LinkedList mergeSort(Node head, Node tail) {
			if (head == tail) {
				LinkedList br = new LinkedList();
				br.addLast(head.data);
				return br;
			}

			Node mid = midNode(head, tail);
			LinkedList fsh = mergeSort(head, mid);
			LinkedList ssh = mergeSort(mid.next, tail);
			LinkedList sl = mergeTwoSortedLists(fsh, ssh);
			return sl;
		}

		public void removeDuplicates() {
			LinkedList res = new LinkedList();

			while (this.size() > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (res.size() == 0 || val != res.tail.data) {
					res.addLast(val);
				}
			}

			this.head = res.head;
			this.tail = res.tail;
			this.size = res.size;
		}

		public void oddEven() {
			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();

			while (this.size > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (val % 2 == 0) {
					even.addLast(val);
				} else {
					odd.addLast(val);
				}
			}

			if (odd.size > 0 && even.size > 0) {
				odd.tail.next = even.head;

				this.head = odd.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;
			} else if (odd.size > 0) {
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			} else if (even.size > 0) {
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}
		}

		public void kReverse(int k) {
			LinkedList prev = null;

			while (this.size > 0) {
				LinkedList curr = new LinkedList();

				if (this.size >= k) {
					for (int i = 0; i < k; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addFirst(val);
					}
				} else {
					int sz = this.size;
					for (int i = 0; i < sz; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addLast(val);
					}
				}

				if (prev == null) {
					prev = curr;
				} else {
					prev.tail.next = curr.head;
					prev.tail = curr.tail;
					prev.size += curr.size;
				}
			}

			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;
		}

		private void displayReverseHelper(Node node) {
			if (node == null) {
				return;
			}
			displayReverseHelper(node.next);
			System.out.print(node.data + " ");
		}

		public void displayReverse() {
			displayReverseHelper(head);
			System.out.println();
		}

		private void reversePRHelper(Node node) {
			if (node == tail) {
				return;
			}
			reversePRHelper(node.next);
			node.next.next = node;
		}

		public void reversePR() {
			reversePRHelper(head);
			Node temp = head;
			head = tail;
			tail = temp;
			tail.next = null;
		}

		public static int additionHelper(Node head1, int idx1, Node head2, int idx2, LinkedList ans) {
			if (head1 == null || head2 == null) {
				return 0;
			}

//			if(idx1 == 1 && idx2 == 1) {  also correct
//				ans.addFirst((head1.data + head2.data)%10);
//				return (head1.data + head2.data)%10;
//			}

			int carry = 0;
			int sum = 0;
			if (idx1 > idx2) {
				carry = additionHelper(head1.next, idx1 - 1, head2, idx2, ans);
				sum = head1.data + carry;
			} else if (idx2 > idx1) {
				carry = additionHelper(head1, idx1, head2.next, idx2 - 1, ans);
				sum = head2.data + carry;
			} else {
				carry = additionHelper(head1.next, idx1 - 1, head2.next, idx2 - 1, ans);
				sum = head1.data + head2.data + carry;
			}

			ans.addFirst(sum % 10);
			return sum / 10;

		}

		public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
			LinkedList ans = new LinkedList();
			int carry = additionHelper(one.head, one.size(), two.head, two.size(), ans);
			if (carry != 0)
				ans.addFirst(carry);
			return ans;
		}

		public static LinkedList addTwoList1(LinkedList one, LinkedList two) {
			LinkedList ans = new LinkedList();
			one.reversePI();
			two.reversePI();

			Node h1 = one.head;
			Node h2 = two.head;
			int carry = 0;

			while (h1 != null || h2 != null) {
				int no1 = (h1 != null) ? h1.data : 0;
				int no2 = (h2 != null) ? h2.data : 0;
				int sum = no1 + no2 + carry;
				ans.addLast(sum % 10);
				carry = sum / 10;
				if (h1 != null)
					h1 = h1.next;
				if (h2 != null)
					h2 = h2.next;
			}

			if (carry != 0)
				ans.addLast(carry);

			ans.reversePI();
			one.reversePI();
			two.reversePI();

			return ans;
		}
		
		
		//GFG
	    static int add(Node first, int sz1, Node second, int sz2, Node res){
	        if(first == null){
	            return 0;
	        }
	        
	        int no = 0, carry = 0;
	        if(sz1 > sz2){
	            carry = add(first.next, sz1-1, second, sz2, res);
	            no = first.data + carry;
	        }else if(sz2 > sz1){
	            carry = add(first, sz1, second.next, sz2-1, res);
	            no = second.data + carry;
	        }else{
	            carry = add(first.next, sz1-1, second.next, sz2-1, res);
	            no = first.data + second.data + carry;
	        }
	        
	        Node node = new Node(no%10);
	        node.next = res.next;
	        res.next = node;
	        
	        return no/10;
	        
	    }
	    
	    static Node addTwoLists(Node first, Node second){
	        int sz1 = 0, sz2 = 0;
	        Node head = first;
	        
	        while(head != null){
	            head = head.next;
	            sz1++;
	        }
	        
	        head = second;
	        while(head != null){
	            head = head.next;
	            sz2++;
	        }
	        
	        Node res = new Node(0);
	        int carry = add(first, sz1, second, sz2, res);
	        if(carry != 0){
	            Node node = new Node(carry);
	            node.next = res.next;
	            res.next = node;
	        }
	        
	        return res.next;
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

		int n2 = Integer.parseInt(br.readLine());
		LinkedList l2 = new LinkedList();
		String[] values2 = br.readLine().split(" ");
		for (int i = 0; i < n2; i++) {
			int d = Integer.parseInt(values2[i]);
			l2.addLast(d);
		}

		LinkedList sum = LinkedList.addTwoLists(l1, l2);

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		l1.display();
		l2.display();
		sum.display();
		sum.addFirst(a);
		sum.addLast(b);
		sum.display();
	}
}
