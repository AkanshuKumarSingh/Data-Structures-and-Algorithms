package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class _22_Count_distinct_elements_in_every_window {

	ArrayList<Integer> countDistinct(int arr[], int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		ans.add(map.size());

		for (int i = k; i < n; i++) {
			int freq = map.get(arr[i - k]);
			if (freq - 1 == 0)
				map.remove(arr[i - k]);
			else
				map.put(arr[i - k], freq - 1);
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			ans.add(map.size());
		}

		return ans;
	}

}
