package Hashing;

import java.util.HashSet;

public class _13_Key_Pair {

	boolean hasArrayTwoCandidates(int arr[], int n, int x) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int diff = x - arr[i];
			if (set.contains(diff))
				return true;
			else
				set.add(arr[i]);
		}
		return false;
	}

}
