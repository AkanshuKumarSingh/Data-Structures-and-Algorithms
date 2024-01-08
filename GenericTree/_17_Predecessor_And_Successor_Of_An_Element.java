package GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _17_Predecessor_And_Successor_Of_An_Element {

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

	static Node predecessor1;
	static Node predecessor2;
	
	public static int predecessorAndSuccessor1(Node node, int data) {
		if (predecessor2 == null) {
			predecessor2 = node;
		} else if (predecessor1 == null) {
			predecessor1 = node;
		} else {
			if (predecessor1.data == data) {
				successor = node;
				predecessor = predecessor2;
				return -1;
			}
			predecessor2 = predecessor1;
			predecessor1 = node;
		}
		for (Node child : node.children) {
			if (predecessorAndSuccessor1(child, data) == -1) {
				return -1;
			}
		}
		return 0;

	}

	static Node predecessor;
	static Node successor;
	static int state = 0;
//	public static void predecessorAndSuccessor(Node node, int data) {
//		for above method
//		predecessorAndSuccessor1(node,data);
//		if(predecessor1.data == data) {
//			predecessor = predecessor2;
//		}
//		
//	}

	public static void predecessorAndSuccessor(Node node, int data) {
		if(state == 0) {
			if(node.data == data) {
				state++;
			}else {
				predecessor = node;
			}
		}else if(state == 1) {
			successor = node;
			state++;
		}else {
			return;
		}
		
		for(Node child : node.children) {
			predecessorAndSuccessor(child,data);
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

		int data = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		predecessor = null;
		successor = null;
		predecessorAndSuccessor(root, data);
		if (predecessor == null) {
			System.out.println("Predecessor = Not found");
		} else {
			System.out.println("Predecessor = " + predecessor.data);
		}

		if (successor == null) {
			System.out.println("Successor = Not found");
		} else {
			System.out.println("Successor = " + successor.data);
		}
	}

}
