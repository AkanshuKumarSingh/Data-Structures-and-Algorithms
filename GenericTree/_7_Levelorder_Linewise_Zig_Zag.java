package GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _7_Levelorder_Linewise_Zig_Zag {
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

	public static void levelOrderLinewiseZZ(Node node) {
		Stack<Node> mainS = new Stack<>();
		Stack<Node> helperS = new Stack<>();

		mainS.push(node);

		int level = 0;
		while (!mainS.isEmpty()) {

			while (!mainS.isEmpty()) {
				Node rem = mainS.pop();
				System.out.print(rem.data + " ");

				if (level % 2 == 0) {
					// left to right
					for (Node child : rem.children) {
						helperS.push(child);
					}
				} else {
					// right to left
					for (int i = rem.children.size() - 1; i >= 0; i--) {
						Node child = rem.children.get(i);
						helperS.push(child);
					}
				}

			}

			System.out.println();

			Stack<Node> temp = mainS;
			mainS = helperS;
			helperS = temp;
			level++;
		}

	}

	public static void levelOrderLinewiseZZ1(Node node) {
		// mine
		Stack<Node> mainS = new Stack<>();
		Stack<Node> helperS = new Stack<>();

		mainS.push(node);

		int level = 0;
		while (!mainS.isEmpty()) {

			Node rem = mainS.pop();
			System.out.print(rem.data + " ");

			if (level % 2 == 0) {
				// left to right
				for (Node child : rem.children) {
					helperS.push(child);
				}
			} else {
				// right to left
				for (int i = rem.children.size() - 1; i >= 0; i--) {
					Node child = rem.children.get(i);
					helperS.push(child);
				}
			}


			if (mainS.isEmpty()) {
				System.out.println(); 
				Stack<Node> temp = mainS;
				mainS = helperS;
				helperS = temp;
				level++;
			}
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
		levelOrderLinewiseZZ(root);
	}

}
