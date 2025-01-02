package Recursion_and_Backtracking;

public class _53_Largest_number_in_K_swaps {

	static class Res {
		static String max = "";
	}

	public static void findMaximumNum(char ar[], int k, Res r, int idx) {
		if (k == 0)
			return;
		int n = ar.length;
		for (int i = idx; i < n - 1; i++) {
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
					findMaximumNum(ar, k - 1, r, idx+1);

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

    public static void findMax(char nos[], int idx, int n, int k, Res res){
        if(k  == 0) return;
        if(idx == n) return;
        
        boolean flag = false;
    	for(int j = idx+1; j < n; j++){
            if(nos[idx] < nos[j]){
                char temp = nos[idx];
                nos[idx] = nos[j];
                nos[j] = temp;

                String st = new String(nos);
    			if (res.max.compareTo(st) < 0) {
        			res.max = st;
    			}

                findMax(nos, idx+1, n,k-1, res);

                temp = nos[idx];
                nos[idx] = nos[j];
                nos[j] = temp;
                flag = true;
            }
        }
    	
    	if(!flag) {
    		findMax(nos, idx+1, n,k, res);
    	}
        
    }
    
    //Function to find the largest number after k swaps.
    public static String findMaximumNum1(String str, int k){
        Res res = new Res();
        res.max = str;
        char nos[] = str.toCharArray();
        findMax(nos, 0, nos.length, k, res);
        return res.max;
    }
	
	public static void main(String[] args) {
		String str = "4551711527";
		int k = 3;
		Res r = new Res();
		r.max = str;
//		findMaximumNum(str.toCharArray(), k, r, 0);
//		System.out.println(r.max);
		
		// This code not working as we can have 2 types of cases
		// first if no is 54177, k = 1 now we need to choose 2nd 7 and second if no is 61979, k = 2 in this 
		// we need to choose in this we need to choose 1st 8 for k=1
		System.out.println(findMaximumNum1(str, k));
	}

}
