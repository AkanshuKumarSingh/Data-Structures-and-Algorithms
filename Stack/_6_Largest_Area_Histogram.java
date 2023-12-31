package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6_Largest_Area_Histogram {
	
	public static int[] nslIndex(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(arr.length-1);
		int res[] = new int[arr.length];
		
		for(int i = arr.length-2; i >= 0; i--) {
			while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			res[st.pop()] = -1;
		}
		return res;
	}
	
	
	public static int[] nsrIndex(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int res[] = new int[arr.length];
		
		for(int i = 1; i < arr.length; i++) {
			while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			res[st.pop()] = arr.length;
		}
		return res;
	}
	
	public static int findArea(int arr[]) {
		int lsi[] = nslIndex(arr);
		int rsi[] = nsrIndex(arr);
		int area = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int ht = arr[i];
			int width = rsi[i] - lsi[i] - 1;
			area = Math.max(area, ht*width);
		}
		
		return area;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("HHM");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(findArea(a));
	}

}
