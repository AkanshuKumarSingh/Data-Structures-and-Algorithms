package BinaryTree;

import java.util.Stack;

public class SubsequenceUsingStack {

	public static class Node {
		int indx;
		String ans;
		int state;

		Node(int indx, String ans, int state) {
			this.indx = indx;
			this.ans = ans;
			this.state = state;
		}
	}

	public static void main(String[] args) {
		String ans = "abc";
		
		Stack<Node> st = new Stack<>();
		st.push(new Node(0,"",0));
		
		while(!st.isEmpty()) {
			Node n = st.peek();
			
			if(n.indx == ans.length()) {
				System.out.println(n.ans);
				st.pop();
				continue;
			}
			if(n.state == 0) {
				st.push(new Node(n.indx+1,n.ans + ans.charAt(n.indx), 0));
				n.state++;
			}else if(n.state == 1) {
				st.push(new Node(n.indx+1, n.ans + "_", 0));
				n.state++;
			}else {
				st.pop();
			}
			
		}
		
	}

}
