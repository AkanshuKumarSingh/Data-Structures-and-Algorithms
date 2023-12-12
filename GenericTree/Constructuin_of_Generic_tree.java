package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Constructuin_of_Generic_tree {

	public static class Node {
		int data;
		ArrayList<Node> children;

		public Node() {
			this.data = 0;
			this.children = new ArrayList<>();
		}

		public Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}

	}
	
	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0]);
		Stack<Node> st = new Stack<>();
		st.push(root);
		
		for(int i = 1; i < arr.length; i++) {
			Integer no = arr[i];
			if(no == null) {
				st.pop();
			}else {
				Node nn = new Node(no);
				st.peek().children.add(nn);
				st.push(nn);
			}
		}
		
		
		return root;
	}

	public static void display(Node node) {
		//self work
		System.out.print(node.data + " -> ");
		for(Node child : node.children) {
			System.out.print(child.data + " ");
		}
		System.out.println(".");
		
		//faith work
		for(Node child : node.children) {
			display(child);
		}
		
	}
	
//	prearea : before calling children in this recursion
//	inarea : area btw calling its children
//	postarea: after coming out from recursion
	
	public static void main(String[] args) {
		// Given data is of euler traversal
		// we are just visiting each node and then calling for each of its children
		// and in prearea(before calling in this recursion)  of node we are printing 
		// node.data and in postarea( after coming out from recursion)  we are printing
		// null as a sign that this node calling is finished
		Integer data[] = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
				null, 40, 100, null, null, null };
		Node root = construct(data);
		display(root);

	}
}
