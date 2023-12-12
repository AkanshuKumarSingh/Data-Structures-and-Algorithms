package GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Diameter_Of_Generic_Tree {
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

	// Diameter of Generic Tree is distance btw two farthest node in tree
	
	// Diameter can on the left side or right side on any root or pass through it 
	// So we should give chance to every node.
	
	static int Diameter = 0;
	
	public static int height(Node root) {
		int ht = -1;
		
		for(Node child : root.children) {
			ht = Math.max(ht, height(child));
		}
		
		return ht+1;
	}
	
	public static void diameter(Node root) {
		
		int max = -1;
		int secondMax = -1;
		
		for(Node child : root.children) {
			diameter(child);
		}
		
		for(Node child : root.children) {
			int ht = height(child);
			
			if(ht > max) {
				secondMax = max;
				max = ht;
			}else if(ht > secondMax) {
				secondMax = ht;
			}
		}
		
		Diameter = Math.max(Diameter, max+secondMax+2);
	}
	
	public static int heightForDiameter(Node root) {
		
		int max = -1;
		int secondMax = -1;
		
		for(Node child : root.children) {
			int ht = heightForDiameter(child);
			
			if(max < ht) {
				secondMax = max;
				max = ht;
			}else if(secondMax < ht) {
				secondMax = ht;
			}
		}
		
		Diameter = Math.max(Diameter, max + secondMax+ 2);
		
		return max + 1;
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
		diameter(root);
		System.out.println(Diameter);
	}

}
