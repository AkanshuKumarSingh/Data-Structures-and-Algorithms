package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _4_Longest_Consecutive_Sequence {

	//1st way
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   HashSet<Integer> set = new HashSet<>();
	   for(int i : arr){
	       set.add(i);
	   }
	   
	   int curr = 0, max = 0;
	   for(int i : arr){
	       int no = i;
	       curr = 0;
	       if(!set.contains(i-1))
    	       while(set.contains(no)){
    	           curr++;
    	           no++;
    	       }
	       max = Math.max(curr, max);
	       
	   }
	   return max;
	}
	
	//2nd way
	public static void main(String[] args) throws Exception {
		HashMap<Integer, Boolean> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int arr[] = new int[n];
		
		
		// 2nd way
		// fill all nos in hashmap as true
		for(int i = 0 ; i < n; i++) {
			arr[i] = scan.nextInt();
			map.put(arr[i], true);
		}
		
		// put false to those no whose no-1 exists means they can't be starting no
		for(int i = 0 ; i < arr.length; i++) {
			if(map.containsKey(arr[i]-1)) {
				map.put(arr[i], false);
			}
		}
		
		int len = 0;
		int sp = 0;
		
		//find longest consecutive subsequence for each starting no as they have true as value
		for(int i = 0 ; i < arr.length; i++) {
			if(map.get(arr[i]) == true) {
				int ele = arr[i];
				int cnt = 1;
				
				while(map.containsKey(ele + cnt)) {
					cnt++;
				}
				
				if(cnt > len) {
					sp = ele;
					len = cnt;
				}
				
			}
		}
		
		for(int i = 1; i <= len; i++) {
			System.out.println(sp);
			sp++;
		}
		
	}

}
