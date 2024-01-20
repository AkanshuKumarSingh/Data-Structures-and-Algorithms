package Hashing;

import java.util.HashSet;

public class _6_Union_of_two_arrays {

	public static int doUnion(int a[], int n, int b[], int m) {
		HashSet<Integer> set = new HashSet<>();
		for (int no : a) {
			set.add(no);
		}
		for (int no : b) {
			set.add(no);
		}
		return set.size();
	}

}
