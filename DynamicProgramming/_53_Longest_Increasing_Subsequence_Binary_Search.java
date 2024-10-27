package DynamicProgramming;

import java.util.*;

public class _53_Longest_Increasing_Subsequence_Binary_Search {

	static int longestSubsequence(int n, int arr[]) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);

		for (int i = 1; i < n; i++) {
			if (arr[i] > list.get(list.size() - 1)) {
				list.add(arr[i]);
			} else {
				int idx = Collections.binarySearch(list, arr[i]);
				if (idx < 0) {
					idx = -(idx + 1); // Get the insertion point
				}
				list.set(idx, arr[i]);
			}
		}

		return list.size();
	}

}
