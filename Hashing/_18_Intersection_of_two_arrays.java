package Hashing;

import java.util.HashSet;

public class _18_Intersection_of_two_arrays {
	public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
		// System.out.println("HHM");
		HashSet<Integer> set = new HashSet<>();
		int cnt = 0;
		for (int i : a) {
			set.add(i);
		}
		for (int i : b) {
			if (set.contains(i)) {
				cnt++;
				set.remove(i);
			}
		}
		return cnt;
	}
}
