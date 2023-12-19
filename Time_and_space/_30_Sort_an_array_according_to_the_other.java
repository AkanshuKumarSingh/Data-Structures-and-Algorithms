package Time_and_space;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _30_Sort_an_array_according_to_the_other {

	public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {
		// System.out.println("JMD");
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : A1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int j = 0;
		for (int i : A2) {
			if (map.containsKey(i)) {
				int time = map.get(i);
				while (time-- > 0) {
					A1[j++] = i;
				}
				map.remove(i);
			}
		}
		int k = j;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int i = e.getKey();
			int time = e.getValue();
			while (time-- > 0) {
				A1[k++] = i;
			}
		}
		Arrays.sort(A1, j, N);
		return A1;
	}

}
