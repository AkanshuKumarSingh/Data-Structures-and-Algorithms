package Recursion_and_Backtracking;

public class _53_Largest_number_in_K_swaps {

	static class Res {
		static String max = "";
	}

	public static void findMaximumNum(char ar[], int k, Res r) {
		if (k == 0)
			return;
		int n = ar.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
					// if digit at position i is less than digit
					// at position j, we swap them and check for
					// maximum number so far.
				if (ar[j] > ar[i]) {
					char temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;

					String st = new String(ar);

					// if current number is more than
					// maximum so far
					if (r.max.compareTo(st) < 0) {
						r.max = st;
					}
					// calling recursive function to set the
					// next digit.
					findMaximumNum(ar, k - 1, r);

					// backtracking
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
	}

	
	
	public static void findMaxNo(char str[], int k, int st) {
		if (k == 0)
			return;
		if (st == str.length)
			return;

		char max = '@';
		int idx = -1;
		for (int i = st + 1; i < str.length; i++) {
			if (str[st] < str[i] && (max == '@' || max <= str[i])) {
				max = str[i];
				idx = i;
			}
		}
		
//		String ans = "";
//		for (char ch : str)
//			ans += ch;
//		
//		System.out.println(ans);
//		System.out.println(idx + " " + max);
		if (idx != -1) {
			char t = str[st];
			str[st] = str[idx];
			str[idx] = t;
			k--;
		}
		findMaxNo(str, k , st + 1);

	}

	public static String findMaximumNum(String str, int k) {
		char nos[] = str.toCharArray();
		findMaxNo(nos, k, 0);
		String ans = "";
		for (char ch : nos)
			ans += ch;
		return ans;
	}

	public static void main(String[] args) {
		String str = "61979";
		int k = 2;
		Res r = new Res();
		r.max = str;
		findMaximumNum(str.toCharArray(), k, r);
		System.out.println(r.max);
		
		// This code not working as we can have 2 types of cases
		// first if no is 54177, k = 1 now we need to choose 2nd 7 and second if no is 61979, k = 2 in this 
		// we need to choose in this we need to choose 1st 8 for k=1
		System.out.println(findMaximumNum(str, k));
	}

}
