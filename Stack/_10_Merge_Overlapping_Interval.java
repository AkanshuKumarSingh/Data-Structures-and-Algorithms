package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class _10_Merge_Overlapping_Interval {
	
//	https://leetcode.com/problems/merge-intervals/submissions/

	public static class Pair implements Comparable<Pair> {
		int st;
		int end;

		public Pair(int st, int end) {
			this.st = st;
			this.end = end;
		}

		public int compareTo(Pair other) {
			return this.st - other.st;
		}

	}

	public static void main(String[] args) throws Exception {
		// write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int j = 0; j < n; j++) {
			String line = br.readLine();
			arr[j][0] = Integer.parseInt(line.split(" ")[0]);
			arr[j][1] = Integer.parseInt(line.split(" ")[1]);
		}

		mergeOverlappingIntervals(arr);
	}

	public static void mergeOverlappingIntervals(int[][] arr) {
		// merge overlapping intervals and print in increasing order of start time
		Pair pairs[] = new Pair[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int st = arr[i][0];
			int end = arr[i][1];

			pairs[i] = new Pair(st, end);

		}

		Arrays.sort(pairs);

//		for(Pair p : pairs) {
//			System.out.println(p.st + " " + p.end);
//		}

		Stack<Pair> st = new Stack<>();
		st.push(pairs[0]);

		for (int i = 1; i < pairs.length; i++) {
			Pair p = pairs[i];
			if(st.peek().end >= p.st) {
				if(st.peek().end < p.end) {
					st.peek().end = p.end;
				}
			}else {
				st.push(p);
			}
		}

		Stack<Pair> st2 = new Stack<>();
		while(st.size()> 0) {
			st2.push(st.pop());
		}
		
		while(st2.size() > 0) {
			Pair rem = st2.pop();
			System.out.println(rem.st + " " + rem.end);
		}
		
	}

	public static void mergeOverlappingIntervals1(int[][] arr) {
		// merge overlapping intervals and print in increasing order of start time
		Pair pairs[] = new Pair[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int st = arr[i][0];
			int end = arr[i][1];

			pairs[i] = new Pair(st, end);

		}

		Arrays.sort(pairs);

//		for(Pair p : pairs) {
//			System.out.println(p.st + " " + p.end);
//		}

		Pair res = pairs[0];

		for (int i = 1; i < pairs.length; i++) {
			Pair p = pairs[i];
			if(res.end >= p.st) {
				if(res.end < p.end) {
					res.end = p.end;
				}
			}else {
				System.out.println(res.st + " " + res.end);
				res = p;
			}
		}

		System.out.println(res.st + " " + res.end);
	}

	
}
