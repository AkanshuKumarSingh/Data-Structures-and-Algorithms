package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void display(int arr[]) {
		for (int no : arr) {
			System.out.print(no + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		int ans[] = nge(arr);
		display(ans);

		ans = pge(arr);
		display(ans);
		
		ans = nse(arr);
		display(ans);
		
		ans = pse(arr);
		display(ans);
	}

	public static int[] nge(int arr[]) {
		Stack<Integer> st = new Stack<>();
		int res[] = new int[arr.length];
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] > arr[st.peek()]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while(st.size() > 0) {
			res[st.pop()] = -1;
		}
		
		return res;
	}

	public static int[] pge(int arr[]) {
		Stack<Integer> st = new Stack<>();
		int res[] = new int[arr.length];
		st.push(arr.length-1);
		
		for(int i = arr.length-2 ; i >= 0; i--) {
			while(st.size() > 0 && arr[i] > arr[st.peek()]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while(st.size() > 0) {
			res[st.pop()] = -1;
		}
		
		return res;
	}
	
	public static int[] nse(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int res[] = new int[arr.length];
		
		for(int i = 1; i < arr.length; i++) {
			while(st.size() > 0 && arr[i] < arr[st.peek()]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while(st.size() > 0) {
			res[st.pop()] = -1;
		}
		
		return res;
	}
	
	public static int[] pse(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(arr.length-1);
		int res[] = new int[arr.length];
		
		for(int i = arr.length-2 ; i >= 0; i--) {
			while(st.size() > 0 && arr[i] < arr[st.peek()]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while(st.size() > 0) {
			res[st.pop()] = -1;
		}
		
		return res;
	}
	
}
