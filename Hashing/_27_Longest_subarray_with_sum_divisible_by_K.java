package Hashing;

import java.util.HashMap;

public class _27_Longest_subarray_with_sum_divisible_by_K {

	int longSubarrWthSumDivByK(int a[], int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, ans = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (sum % k == 0)
				ans = i + 1;

			int rem = ((sum % k) + k) % k;

			if (map.containsKey(rem)) {
				ans = Math.max(ans, i - map.get(rem));
			} else {
				map.put(rem, i);
			}

		}
		return ans;
	}

}
