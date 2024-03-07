package Sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _35_Merge_k_Sorted_Arrays {

    public static class Node implements Comparable<Node>{
        int idx;
        int listIdx;
        int no;
        
        Node(int no, int idx){
            this.no = no;
            this.idx = idx;
        }
        
        Node(int no, int idx, int listIdx){
            this.no = no;
            this.idx = idx;
            this.listIdx = listIdx;
        }
        
        public int compareTo(Node obj){
            return this.no - obj.no;
        }
        
    }
    
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i = 0 ; i < arr.length; i++){
            q.offer(new Node(arr[i][0], 0, i));
        }
        
        while(!q.isEmpty()){
            Node node = q.poll();
            ans.add(node.no);
            if(arr[node.listIdx].length > node.idx+1)
                q.offer(new Node(arr[node.listIdx][node.idx+1], node.idx+1, node.listIdx));
        }
        
        return ans;
    }
	
    public static void main(String args[]) {
    	int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
    	int k = 3;
    	System.out.println(mergeKArrays(arr, k));
    }

    
}
