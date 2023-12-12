package Stack;

import java.util.Arrays;
import java.util.Scanner;

public class Next_Greater_Element_II {

	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int res[] = dailyTemperatures(arr);
		System.out.println(Arrays.toString(res));

}
