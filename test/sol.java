package test;

public class sol {
	// abab
	// k = 2, k operations to change char of str, len of longest substring
	// aababba, k = 1, abzswq
	
	public static void main(String[] args) {
		String str = "a";
		int k;
//		a : 4, 3, 1, 3-1-1 = 1
//		b : 1, 2, 2
//		
		char prev = str.charAt(0);
		int cnt = 1, max = 1;
		for(int i = 1 ; i < str.length(); i++) {
			if(prev == str.charAt(i)) {
				cnt++;
				max = Math.max(max, cnt);
			}else {
				prev = str.charAt(i);
				cnt = 1;
			}
		}
		System.out.println(max);
	}

}
