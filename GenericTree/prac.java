package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class prac {

	public static class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
		Node(int data){
			this.data = data;
		}
	}
	
	public static Node construct(Integer arr[]) {
		Node root = new Node(arr[0]);
		Stack<Node> st = new Stack<>();
		st.push(root);
		
		int index = 1;
		while(index < arr.length) {
			Integer no = arr[index++];
			if(no == null) {
				st.pop();
				continue;
			}
			
			Node node = new Node(no);
			st.peek().children.add(node);
			st.push(node);
		}
		return root;
	}
	
	public static void traversals(Node root) {
//		System.out.println(root.data);
		
		for(Node node: root.children) {
//			System.out.println(root.data + "-----" + node.data);
			traversals(node);
			System.out.println(root.data + "-----" + node.data);

		}
		
//		System.out.println(root.data);
		
	}
	
	public static void print(Node root) {
		System.out.print(root.data + "->");
		for(Node node : root.children) {
			System.out.print(node.data + ", ");
		}
		
		System.out.println();
		
		for(Node node: root.children) {
			print(node);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("JMD");
		Integer[] arr = {10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null,
				null, 40, 100, null, null, null, null
		};
		Node root = construct(arr);
		print(root);
		System.out.println();
		traversals(root);
	}

}
