package Hashing;

import java.util.*;


public class Highest_Frequency_Character {

	public static void main(String[] args) throws Exception {
		HashMap<Character,Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}else {
				map.put(ch, 1);
			}	
		}

		char ans = '@';
		int maxCnt = 0;
		for(char key : map.keySet()) {
			if(map.get(key) > maxCnt) {
				maxCnt = map.get(key);
				ans = key;
			}
		}
		System.out.println(ans);
	}

}
