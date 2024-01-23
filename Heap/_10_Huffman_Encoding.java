package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _10_Huffman_Encoding {

    static class Node implements Comparable<Node>{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public int compareTo(Node temp){
            if(this.data == temp.data){
                return 1;
            }
            return this.data - temp.data;
        }
    }
    
    public void preOrder(Node root, String no, ArrayList<String> ans){
        if(root.left == null && root.right == null){
            ans.add(no);
            return;
        }
        // System.out.println(root.data);
        preOrder(root.left, no + "0", ans);
        preOrder(root.right, no + "1", ans);
    }
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // System.out.println("JSR");
        PriorityQueue<Node> q = new PriorityQueue<>();
        ArrayList<String> ans = new ArrayList<>();
        for(int no : f){
            q.offer(new Node(no));
        }
        
        while(q.size() > 1){
            Node left = q.poll();
            Node right = q.poll();
            Node node = new Node(left.data + right.data);
            node.left = left;
            node.right = right;
            q.offer(node);
        }
        
        preOrder(q.peek(), "", ans);
        return ans;
    }
	
}
