package BinaryTree;

import java.util.*;

public class _72_Make_Binary_Tree_From_Linked_List {

	static class Tree{
	int data;
	    Tree left;
	    Tree right;
	    Tree(int d){
	        data=d;
	        left=null;
	        right=null;
	    }
	}

	static class Node {
	    int data;
	    Node next;
	    Node(int d) {
	        data = d;
	        next = null;
	    }
	}
	
	public static Tree convert(Node head, Tree node) {

		// System.out.println("HHM");
		if (head.next == null)
			return new Tree(head.data);
		Queue<Tree> q = new LinkedList<>();
		Tree curr = null, newHead = null;
		q.offer(new Tree(head.data));
		head = head.next;

		while (head != null) {
			curr = q.peek();

			if (newHead == null)
				newHead = curr;
			if (curr.left == null) {
				curr.left = new Tree(head.data);
				q.offer(curr.left);
			} else if (curr.right == null) {
				curr.right = new Tree(head.data);
				q.offer(curr.right);
			} else {
				q.poll();
				continue;
			}
			head = head.next;
		}
		return newHead;
	}

}
