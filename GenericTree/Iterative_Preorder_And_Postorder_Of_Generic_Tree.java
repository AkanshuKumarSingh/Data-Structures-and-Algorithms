package GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Iterative_Preorder_And_Postorder_Of_Generic_Tree {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public static Node construct(int[] arr) {
		Node root = null;

		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}

				st.push(t);
			}
		}

		return root;
	}

	public static class IPair {
		Node node;
		int state;

		IPair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void prac(Node root) {
		Stack<IPair> st = new Stack<>();
		st.push(new IPair(root,-1));
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();
		
		
		while(!st.isEmpty()) {
			IPair p = st.pop();
			
			if(p.state == -1) {
				pre.add(p.node.data);
				p.state++;
			}else if(p.state >= 0 && p.state < p.node.children.size()) {
				st.push(new IPair(p.node.children.get(p.state),-1));
				p.state++;
			}else{
				post.add(p.node.data);
				p.state++;
				st.pop();
			}
		}
		
		System.out.println(pre);
		System.out.println(post);
	}
	
	public static void IterativePreandPostOrder(Node root) {
		Stack<IPair> st = new Stack<>();

		st.push(new IPair(root, -1));
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();

		while (st.size() > 0) {
			IPair p = st.peek();

			if (p.state == -1) {
				pre.add(p.node.data);
				p.state++;
			} else if (p.state >= 0 && p.state < p.node.children.size()) {
				Node child = p.node.children.get(p.state);
				st.push(new IPair(child,-1));
				p.state++;
			} else {
				post.add(p.node.data);
				st.pop();
			}
		}

		for(int i : pre) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int j : post) {
			System.out.print(j + " ");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}

		Node root = construct(arr);
		IterativePreandPostOrder(root);
	}

}
