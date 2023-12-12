package DynamicProgramming;

import java.util.Scanner;

public class count_a_b_c_subsequence {
	
	public static int abcTabulation(String str) {
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == 'a') {
				aCount = 2*aCount + 1;
			}else if(ch == 'b') {
				bCount = 2*bCount + aCount;
			}else {
				cCount = 2*cCount + bCount;
			}
		}
		
		return cCount;
	}
	
	public static int subSequences(String str, int indx, int le, String res){
        if(indx == str.length()){
            if(le == 2){
            	System.out.println(res);
                return 1;
            }
            return 0;
        }
        
        char prevChar = (char)('a' + le);
        int ans = 0;
        for(int i = indx; i < str.length(); i++){
            char currChar = str.charAt(i);
            if(currChar == prevChar){
                ans += subSequences(str, i+1, le, res + i +" ");
            }else if(currChar == prevChar+1){
            	ans += subSequences(str, i+1, le+1, res + i +" ");
            }
        }
        
        // because suppose we have abcabc so a combination abc then if we will not put
        // below code then it will only make abccc and count it not place for abc
    	if(le == 2) ans += 1;
        return ans;
    }
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(abcTabulation(str));
		
        System.out.println(subSequences(str, 0, -1, ""));
	}

}
