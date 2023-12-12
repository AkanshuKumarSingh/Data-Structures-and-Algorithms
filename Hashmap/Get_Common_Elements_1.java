package Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Get_Common_Elements_1 {

	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);

		int n1 = scan.nextInt();
		
		while(n1-- > 0) {
			System.out.println(n1);
		}
		
		for (int i = 0; i < n1; i++) {
			int no = scan.nextInt();
			map.put(no, 1);
		}

		int n2 = scan.nextInt();

		for (int i = 0; i < n2; i++) {
			int no = scan.nextInt();
			if (map.containsKey(no)) {
				System.out.println(no);
				map.remove(no);
			}
		}
	}

}
