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


//	class Pair:
//	    def __init__(self, st, end):
//	        self.st = st
//	        self.end = end
//
//	    def __lt__(self, other):
//	        return self.st < other.st
//
//
//	def merge_overlapping_intervals(arr):
//	    # Convert array of [start, end] into Pair objects
//	    pairs = [Pair(st, end) for st, end in arr]
//	    
//	    # Sort based on start time
//	    pairs.sort()
//
//	    stack = []
//	    stack.append(pairs[0])
//
//	    for i in range(1, len(pairs)):
//	        top = stack[-1]
//	        current = pairs[i]
//
//	        if top.end >= current.st:
//	            if top.end < current.end:
//	                top.end = current.end
//	        else:
//	            stack.append(current)
//
//	    # Reverse the stack to maintain output order
//	    result = []
//	    while stack:
//	        result.append(stack.pop())
//	    result.reverse()
//
//	    # Print the merged intervals
//	    for p in result:
//	        print(p.st, p.end)

	
	
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
