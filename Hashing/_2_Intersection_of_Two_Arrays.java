package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class _2_Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            if(set1.contains(i)) set2.add(i);
        }

        int ans[] = new int[set2.size()];
        Iterator<Integer> it = set2.iterator();
        for(int i = 0 ; i < set2.size(); i++){
            ans[i] = it.next();
        }

        return ans;
    }

	
	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);

		int n1 = scan.nextInt();
		
		while(n1-- > 0) {
			System.out.println(n1);
		}
		
		for (int i = 0; i < n1; i++) {
			int no = scan.nextInt();
			map.put(no, 1);
		}

		int n2 = scan.nextInt();

		for (int i = 0; i < n2; i++) {
			int no = scan.nextInt();
			if (map.containsKey(no)) {
				System.out.println(no);
				map.remove(no);
			}
		}
	}

}
