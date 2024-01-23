package Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _3_Merge_K_Sorted_Arrays {

    static class Node implements Comparable<Node>{
        int no, row, col;
        Node(int no, int row, int col){
            this.row = row;
            this.no = no;
            this.col = col;
        }
        
        public int compareTo(Node node){
            return this.no - node.no;
        }
        
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i = 0 ; i < arr.length; i++){
            q.offer(new Node(arr[i][0], i, 0));
        }
        
        while(!q.isEmpty()){
            Node node = q.poll();
            ans.add(node.no);
            if(node.col + 1 < arr[node.row].length){
                q.offer(new Node(arr[node.row][node.col+1], node.row, node.col+1));
            }
        }
        return ans;
    }
	
	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		int r = lists.size();
		for (int i = 0; i < r; i++) {
			pq.offer(new int[] { lists.get(i).get(0), i, 0 });
		}

		while (!pq.isEmpty()) {
			int rem[] = pq.poll();
			rv.add(rem[0]);
			if (rem[2] + 1 < lists.get(rem[1]).size()) {
				pq.add(new int[] {lists.get(rem[1]).get(rem[2]+1),rem[1],rem[2]+1});
			}
		}

		return rv;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();

			int n = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}

			lists.add(list);
		}

		ArrayList<Integer> mlist = mergeKSortedLists(lists);
		for (int val : mlist) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
