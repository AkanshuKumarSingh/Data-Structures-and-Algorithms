package GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Levelorder_Linewise_generic_Tree {
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

	public static int size(Node node) {
		int s = 0;

		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;

		return s;
	}

	public static int max(Node node) {
		int m = Integer.MIN_VALUE;

		for (Node child : node.children) {
			int cm = max(child);
			m = Math.max(m, cm);
		}
		m = Math.max(m, node.data);

		return m;
	}

	public static int height(Node node) {
		int h = -1;

		for (Node child : node.children) {
			int ch = height(child);
			h = Math.max(h, ch);
		}
		h += 1;

		return h;
	}

	public static void traversals(Node node) {
		System.out.println("Node Pre " + node.data);

		for (Node child : node.children) {
			System.out.println("Edge Pre " + node.data + "--" + child.data);
			traversals(child);
			System.out.println("Edge Post " + node.data + "--" + child.data);
		}

		System.out.println("Node Post " + node.data);
	}

	//level order using delimiter
	public static void levelOrderLinewise(Node node) {
		Queue<Node> q = new LinkedList<>();

		q.add(node);
		q.add(null); // null or dummy node is delimiter

		while (!q.isEmpty()) {
			Node rem = q.remove();

			if (rem == null) {
				System.out.println();
				if(!q.isEmpty()) {
					q.add(null);
				}
				continue;
			}

			System.out.print(rem.data + " ");

			for (Node child : rem.children) {
				q.add(child);
			}
		}
		
	}

	//level order using 2 queue
	public static void levelOrderLinewise1(Node node) {
		Queue<Node> mainQ = new LinkedList<>();
		Queue<Node> helperQ = new LinkedList<>();
		
		mainQ.add(node);
		
		while(!mainQ.isEmpty()) {
			Node rem = mainQ.remove();
			System.out.print(rem.data + " ");
			for(Node child : rem.children) {
				helperQ.add(child);
			}
			
			if(mainQ.isEmpty()) {
				System.out.println();
				//swapping of queues
				Queue<Node> temp = mainQ;
				mainQ = helperQ;
				helperQ = temp;
			}
		}
		
	}
	
	//level order using one queue (size use)
	public static void levelOrderLinewise2(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		
		while(!q.isEmpty()) {
			int sz = q.size();
			
			while(sz-- > 0) {
				// get + remove
				Node rem = q.remove();
				
				// print
				System.out.print(rem.data + " ");
				
				// add children
				for(Node child : rem.children) {
					q.add(child);
				}
			}
			//level is end
			System.out.println();
			
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
		levelOrderLinewise(root);
	}

}
