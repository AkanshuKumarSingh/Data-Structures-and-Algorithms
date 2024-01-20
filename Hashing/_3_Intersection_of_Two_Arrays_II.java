package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _3_Intersection_of_Two_Arrays_II {

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {
			int no = nums1[i];
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			int no = nums2[i];
			if (map.containsKey(no)) {
				list.add(no);
				int freq = map.get(no);
				if (freq - 1 == 0)
					map.remove(no);
				else
					map.put(no, freq - 1);
			}
		}

		int ans[] = new int[list.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = list.get(i);
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);

		int n1 = scan.nextInt();

		for (int i = 0; i < n1; i++) {
			int no = scan.nextInt();
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		int n2 = scan.nextInt();

		for (int i = 0; i < n2; i++) {
			int no = scan.nextInt();
			if (map.containsKey(no)) {
				System.out.println(no);
				map.put(no, map.get(no) - 1);
				if (map.get(no) == 0) {
					map.remove(no);
				}
			}
		}
	}
}
