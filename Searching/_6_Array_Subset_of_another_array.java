package Searching;

import java.util.HashMap;

public class _6_Array_Subset_of_another_array {

    public String isSubset( long a[], long b[], long n, long m) {
		HashMap<Long, Integer> map = new HashMap<>();
		for(long i : a) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for(long i : b) {
		    int cnt = map.getOrDefault(i, 0);
			if(cnt == 0) {
				return "No";
			}
			map.put(i, cnt-1);
		}
		return "Yes";
    }
	
}
