package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Maximal_Rectangle {
	
//	https://leetcode.com/problems/maximal-rectangle/	
	
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
	

	public static int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) return 0;
		int arr[] = new int[matrix[0].length];
		int area = 0;
		
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[0].length; j++) {
				if(matrix[i][j] == '0') {
					arr[j] = 0;
				}else {
					arr[j] += 1;
				}
			}
			area = Math.max(area, findArea(arr));
		}
		return area;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		char mat[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = scan.nextLine().trim();
			for (int j = 0; j < m; j++) {
				mat[i][j] = str.charAt(j);
			}
		}
		System.out.println(maximalRectangle(mat));
	
	}

}
