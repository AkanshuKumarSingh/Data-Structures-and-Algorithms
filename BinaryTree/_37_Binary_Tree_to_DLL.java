package BinaryTree;

public class _37_Binary_Tree_to_DLL {

	// 1st approach
	static class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	public static class TNode {
		Node head;
		Node tail;

		TNode(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	TNode convert(Node root) {
		if (root == null)
			return null;

		TNode left = convert(root.left);
		TNode right = convert(root.right);
		root.left = null;
		root.right = null;

		if (left != null && right != null) {
			left.tail.right = root;
			root.left = left.tail;
			root.right = right.head;
			right.head.left = root;
			return new TNode(left.head, right.tail);
		} else if (left != null) {
			left.tail.right = root;
			root.left = left.tail;
			return new TNode(left.head, root);
		} else if (right != null) {
			root.right = right.head;
			right.head.left = root;
			return new TNode(root, right.tail);
		} else {
			return new TNode(root, root);
		}

	}

	Node bToDLL(Node root) {
		TNode t = convert(root);
		return t.head;
	}

	
	
	// 2nd approach
    Node root; 
    
    // head --> Pointer to head node of created doubly linked list 
    Node head; 
       
    // Initialize previously visited node as NULL. This is 
    // static so that the same value is accessible in all recursive 
    // calls 
    static Node prev = null; 
   
    // A simple recursive function to convert a given Binary tree  
    // to Doubly Linked List 
    // root --> Root of Binary Tree 
    void BinaryTree2DoubleLinkedList(Node root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedList(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BinaryTree2DoubleLinkedList(root.right); 
    } 
   

	
}
