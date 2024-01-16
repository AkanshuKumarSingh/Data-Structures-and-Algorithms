package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class _19_Boundary_Traversal_of_binary_tree {

	static class Node  
	{ 
	    int data; 
	    Node left, right; 
	   
	    public Node(int d)  
	    { 
	        data = d; 
	        left = right = null; 
	    }
	}
    
    void printLeft(Node root, ArrayList <Integer> ans){
        if(root == null) return;
        
        while(root != null){
            if(root.left == null && root.right == null) return;

            ans.add(root.data);
            if(root.left != null){
                root = root.left;
            }else{
                root = root.right;
            }
        }
    }
    
    void printRight(Node root, ArrayList <Integer> ans){
        if(root == null) return;
        Stack<Integer> st = new Stack<>();
        
        while(root != null){
            if(root.left == null && root.right == null) break;

            st.push(root.data);
            if(root.right != null){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
    }
    
    void printLeaves(Node root, ArrayList <Integer> ans){
        if(root == null) return;
        else if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }
        
        printLeaves(root.left, ans);
        printLeaves(root.right, ans);
        
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node == null) return ans;
	    
	    ans.add(node.data);
	    if(node.left == null && node.right == null) return ans;
	    
	    printLeft(node.left, ans);
	    printLeaves(node, ans);
	    printRight(node.right, ans);
	    
	    return ans;
	}

}
