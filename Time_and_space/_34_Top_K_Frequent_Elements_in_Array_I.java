package Time_and_space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _34_Top_K_Frequent_Elements_in_Array_I {

    static class Node implements Comparable<Node>{
        int no;
        int freq;
        
        Node(int no){
            this.no = no;
            this.freq = 1;
        }
        
        public int compareTo(Node node) {
            if(this.freq != node.freq)
                return this.freq - node.freq;
            return this.no-node.no;
        }
        
        @Override
        public String toString() {
            return "Node{no='" + no + "', freq=" + freq + '}';
        }
    }
    
    public int[] topK(int[] nums, int k) {
        
        ArrayList<Node> list= new ArrayList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).freq++;
            }else{
                map.put(nums[i], new Node(nums[i]));
                list.add(map.get(nums[i]));
            }
        }
        
        Collections.sort(list);
        int ans[] = new int[k];
        n = list.size();
        for(int i = n-1; i >= n-k; i--){
            ans[n-1-i] = list.get(i).no;
        }
        System.out.println(list);
        return ans;

    }
    
    public static void main(String args[]) {
    	int nums[] = {1,1,1,2,2,3,3};
    	int k = 2;
    	System.out.println(new _34_Top_K_Frequent_Elements_in_Array_I().topK(nums, k));
    }

}
